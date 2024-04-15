package com.gyuwangsa.security;

import com.gyuwangsa.dao.RoleUserDao;
import com.gyuwangsa.dao.UserInformationDao;
import com.gyuwangsa.vo.UserVO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

//인증 작업 Class
public class SecurityUserDetailsService implements UserDetailsService {

    @Resource(name = "userInformationDao")
    private UserInformationDao userInformationDao;

    @Resource(name = "roleUserDao")
    private RoleUserDao roleUserDao;

    @Override
    public UserDetails loadUserByUsername(String user_id) throws UsernameNotFoundException {
        try{

            UserVO userVO = userInformationDao.selectUserInfo(user_id);

            if (userVO == null){
                throw new UsernameNotFoundException("회원이 아닙니다.");
            }

            //조회한 ID 인증
            List<String> authorities = roleUserDao.selectRoleUserAuthorities(userVO.getUser_nm());
            List<GrantedAuthority> grantedAuthorities = authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());;
            return new User(userVO.getUser_nm(),userVO.getPassword(),grantedAuthorities);

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
