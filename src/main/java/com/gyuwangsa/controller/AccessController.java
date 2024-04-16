package com.gyuwangsa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gyuwangsa.security.JwtTokenProvider;
import com.gyuwangsa.service.RoleUserService;
import com.gyuwangsa.service.UserInformationService;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class AccessController {

    private static final Logger logger = LoggerFactory.getLogger(UserInformationController.class);

    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    public AccessController(JwtTokenProvider jwtTokenProvider){
        this.jwtTokenProvider = jwtTokenProvider;
    };

    @Resource(name = "userInformationService")
    private UserInformationService userInformationService;

    @Resource(name = "roleEmpService")
    private RoleUserService roleUserService;


    //로그인
    @ResponseBody
    @RequestMapping(value = "/loginForm.do", method = RequestMethod.POST)
    public String loginForm(HttpServletRequest request, RedirectAttributes redirectAttributes){

        logger.info("########## 로그인 검증 ##########");

        String user_id = request.getParameter("user_nm");
        String password = request.getParameter("password");

        try {
            //사용자 인증을 위한 객체 생성
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user_id, password);
            //인증 수행
            Authentication authentication = authenticationManager.authenticate(token);
            //인증 성공 후 인증 객체 설정
            SecurityContextHolder.getContext().setAuthentication(authentication);

            logger.info("########## 로그인 완료 ##########");

            return "redirect://";
        }catch (Exception e){
            e.printStackTrace();
            return "redirect://loginPage.do";
        }
    };

    //
    @RequestMapping(value = "/disconnectionProcess.do", method=RequestMethod.POST)
    public void disconnect(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Map<String, Object> responseBody = new HashMap<>();

        // 로그아웃 성공 시 JWT 토큰 파기 로직 수행
        String jwtToken = jwtTokenProvider.extractToken(request);
        jwtTokenProvider.invalidateToken(jwtToken);

        if(jwtTokenProvider.isTokenBlacklisted(jwtToken) == true) {

            // JWT 토큰 사용이 만료 or 파기됨
            responseBody.put("status", "success");
            responseBody.put("message", "사용자 로그아웃");
        } else {
            responseBody.put("status", "failure");
            responseBody.put("message", "로그아웃 실패");
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().write(new ObjectMapper().writeValueAsString(responseBody));
        response.getWriter().flush();
    }


    @RequestMapping(value="/jwtTokenValidation.do", method = RequestMethod.POST)
    public void jwtTokenValidation(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Map<String, Object> responseBody = new HashMap<>();

        String jwtToken = jwtTokenProvider.extractToken(request);

        // 토큰이 유효한 경우
        if(jwtTokenProvider.isTokenBlacklisted(jwtToken) == false) {

            // JWT 토큰 Claim 설정값 가져오기
            Claims claims = jwtTokenProvider.extractClaims(jwtToken);

            String user_id = claims.getSubject();
            String user_nm = (String)claims.get("user_nm");
            String name = (String)claims.get("name");
            String email = (String)claims.get("email");


            responseBody.put("status", "success");
            responseBody.put("message", "토큰 유효");
            responseBody.put("user_nm", user_nm);
            responseBody.put("name", name);
            responseBody.put("email", email);
        }

        // 토큰이 만료된 경우
        else {

            responseBody.put("status", "failure");
            responseBody.put("message", "토큰 만료");
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().write(new ObjectMapper().writeValueAsString(responseBody));
        response.getWriter().flush();
    }

}
