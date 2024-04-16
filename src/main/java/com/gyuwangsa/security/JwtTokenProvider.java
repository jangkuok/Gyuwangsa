package com.gyuwangsa.security;

import com.gyuwangsa.dao.UserInformationDao;
import com.gyuwangsa.vo.UserVO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

//토큰을 생성하고 검증하는 class
@Component
public class JwtTokenProvider extends OncePerRequestFilter {
/*
*   중요한 보안성 부분
* 1) alg 부분 none 으로 사용 금지!!! 보통 HS256
* 2) 디코딩 변환인 쉬움으로 민감한 유저 정보 사용X 최소한의 정보만 사용
* 3) 시크릿 키 단순하게 사용 금지(생성용키 / 검증용키 사용)
* 4) jwt 탈취 훔치기 어렵게 / 블랙리스트 / 유효시간 짧게 /
* */
    @Resource(name = "userInformationDao")
    private UserInformationDao userInformationDao;

    private final JwtConfig jwtConfig;

    @Autowired
    public JwtTokenProvider(JwtConfig jwtConfig){
        this.jwtConfig = jwtConfig;
    };

    // 블랙리스트에 추가되어야 하는 토큰들을 저장하는 공간
    private Set<String> tokenBlacklist = new HashSet<>();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = extractToken(request);

        //토큰 정보 검증 / jwts 클래스로 비밀키를 전달하고 토큰으로 클레임을 만들 수 있다면 true 반환
        if(StringUtils.hasText(token) == true && validateToken(token) == true){
            Authentication authentication = getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            filterChain.doFilter(request, response);
        }else {
            handleAuthenticationFailure(request, response);
        }
    }

    //jwt 토큰 생성
    public String generateToken(Authentication authentication){

        //회원 아이디 추출
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String user_nm = userDetails.getUsername();

        List<String> roles = Arrays.asList("ROLE_ADMIN", "ROLE_BRAND", "ROLE_USER");


        try {
            //회원 정보 조회
            UserVO userVo = userInformationDao.selectUserInfo(user_nm);
            //토큰 생성 ★★★★★★★★
            String token = Jwts.builder().
                    setSubject(user_nm)
                    .claim("roles", roles) //회원 등급
                    .claim("user_nm", userVo.getUser_nm()) //회원 id
                    .claim("name", userVo.getName()) //회원 이름
                    .claim("email", userVo.getEmail()) // 회원 이메일
                    .setIssuedAt(new Date()) // JWT 토큰 발행 시간
                    .setExpiration(new Date(System.currentTimeMillis() + jwtConfig.getExpiration()))  // JWT 토큰 만료 시간
                    .signWith(SignatureAlgorithm.HS256, jwtConfig.getSecret()) // JWT 토큰 서명 ★★★★★★★★ 보안 중요!! none 사용 금지
                    .compact();

            return token;

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    //토큰 유효성 검증
    public boolean validateToken(String token){
        try {
            //토큰의 서명을 확인하여 변조 여부 검사
            Claims claims = Jwts.parser().setSigningKey(jwtConfig.getSecret()).parseClaimsJws(token).getBody();

            //토큰 만료 시간을 확인하여 만료 여부 검사
            Date expirationDate = claims.getExpiration();
            Date now = new Date();
            if (expirationDate.before(now)){
                System.out.println("토큰 만료");
                return false;
            }
            return true;
        }catch (Exception e){
            System.out.println("토큰 검증 실패");
            return false;
        }
    }

    //토큰 추출 로직 구현 ★★★★★★★★
    public String extractToken(HttpServletRequest request) {
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtils.hasText(header) && header.startsWith("Bearer ")){
            return header.substring("Bearer ".length());
        }else {
            return null;
        }
    }

    public String extractTokenFromRequest(HttpServletRequest request) {

        String authorizationHeader = request.getHeader("Authorization");

        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring(7);
        } else {
            return null;
        }
    }

    //토큰으로부터 인증 객체 생성 로직
    private Authentication getAuthentication(String token){
        Claims claims = Jwts.parser().setSigningKey(jwtConfig.getSecret()).parseClaimsJws(token).getBody();

        //토큰에서 필요한 정보 추출
        String username = claims.getSubject();
        List<String> roles = claims.get("roles", List.class);

        //인증 객체 생성
        List<GrantedAuthority> authorities = roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return new UsernamePasswordAuthenticationToken(username, null, authorities);
    }

    //인증 실패 처리를 수행
    private void handleAuthenticationFailure(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.getWriter().write("유효하지 않은 토큰 또는 만료된 토큰");
    }

    //토큰 파기
    public void invalidateToken(String token) {

        //토큰이 블랙리스트에 없으면 추가
        if(tokenBlacklist.contains(token) == false) {
            tokenBlacklist.add(token);
        }
    }

    //토큰이 블랙리스트에 있는지 확인
    public boolean isTokenBlacklisted(String token) {

        return tokenBlacklist.contains(token);
    }

    //jwt 토큰에서 사용자 정보를 추출
    public Claims extractClaims(String token) {
        //토큰이 블랙리스트에 있는지 확인 후, 블랙리스트에 없으면 클레임을 추출
        if(isTokenBlacklisted(token) == false) {
            return Jwts.parser()
                    .setSigningKey(jwtConfig.getSecret())
                    .parseClaimsJws(token)
                    .getBody();
        } else {
            //토큰이 블랙리스트에 있다면 유효하지 않은 토큰으로 처리
            return null;
        }
    }
}
