package com.gyuwangsa.controller;

import com.gyuwangsa.service.RoleUserService;
import com.gyuwangsa.service.UserInformationService;
import com.gyuwangsa.vo.RoleUserVO;
import com.gyuwangsa.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Controller
public class UserInformationController {

    private static final Logger logger = LoggerFactory.getLogger(UserInformationController.class);

    @Resource(name = "userInformationService")
    private UserInformationService userInformationService;

    @Resource(name = "roleEmpService")
    private RoleUserService roleUserService;

    //회원 가입 페이지 이동
    @RequestMapping(value = "joinUser.do", method = RequestMethod.GET)
    public String joinPage(){
        logger.info("########## 회원가입 페이지 이동 ##########");
        return "joinUser";
    };

    //회원 가입
    @RequestMapping(value = "insertUserJoin.do", method = RequestMethod.POST)
    public String insertUserJoin(HttpServletRequest request, Model model) throws Exception{

        UserVO userVo = new UserVO();

        //오늘 날짜
        Date today = new Date();

        //작성한 값 vo 저장
        userVo.setUser_nm(request.getParameter("user_nm"));

        //비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = request.getParameter("password");

        String encoderPassword = passwordEncoder.encode(password);
        userVo.setPassword(encoderPassword);
        
        userVo.setName(request.getParameter("name"));
        userVo.setEmail(request.getParameter("email"));
        userVo.setPhone(request.getParameter("phone"));
        userVo.setAddr_no(request.getParameter("addr_no"));
        userVo.setAddr(request.getParameter("addr"));
        userVo.setAddr_dtl(request.getParameter("addr_dtl"));
        userVo.setSex_cd(request.getParameter("sex_cd").charAt(0));
        userVo.setPwd_date(today);
        userVo.setLogin_date(today);
        userVo.setPwd_yn('n');
        userVo.setJoin_type(request.getParameter("join_type"));
        userVo.setApi_key("1234");

        //회원 가입
        try {
            userInformationService.insertUserJoin(userVo);
        }catch (Exception e){
            System.out.println("회원 가입 실패");
            e.printStackTrace();
        }

        //권한 등록
        RoleUserVO roleUserVo = new RoleUserVO();

        roleUserVo.setUser_nm(userVo.getUser_nm());
        roleUserVo.setStart_date(today);
        //브랜드 가입일 경우
        if(request.getParameter("brand_cd") != null){
            roleUserVo.setRole_cd("ROLE_ADMIN");
            roleUserVo.setBrand_cd(Integer.parseInt(request.getParameter("brand_cd")));
        }else {
            roleUserVo.setRole_cd("ROLE_USER");
            roleUserVo.setBrand_cd(0);
        }
        roleUserVo.setNote("");

        roleUserService.insertRoleUserInfo(roleUserVo);


        //회원 정보 조회
        try {
            userVo = userInformationService.selectUserInfo(request.getParameter("user_nm"));
        }catch (Exception e){
            System.out.println("회원 정보 조회 실패");
            e.printStackTrace();
        }

        model.addAttribute("user", userVo);
        return "user/userInfo";

    };

    //로그인 페이지 이동
    @RequestMapping(value = "loginPage.do", method = RequestMethod.GET)
    public String loginPage(){
        logger.info("########## 로그인 페이지 이동 ##########");
        return "loginPage";
    };

}
