package com.gyuwangsa.service.impl;

import com.gyuwangsa.dao.UserInformationDao;
import com.gyuwangsa.service.UserInformationService;
import com.gyuwangsa.vo.UserVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("userInformationService")
public class UserInformationServiceImpl implements UserInformationService {

    @Resource(name = "userInformationDao")
    private UserInformationDao userInformationDao;

    //회원 정보 저장
    @Override
    public int insertUserJoin(UserVO vo) throws Exception {
        System.out.println("===> <회 원> Service insertUserJoin() 기능 처리");
        return userInformationDao.insertUserJoin(vo);
    }

    //회원 정보 조회
    @Override
    public UserVO selectUserInfo(String user_nm) throws Exception {

        UserVO vo = new UserVO();
        try {
            System.out.println("===> <회 원> Service selectUserInfo() 기능 처리");
            vo = userInformationDao.selectUserInfo(user_nm);
            if(vo == null){
                throw new Exception("회원이 없습니다.");
            }
            return vo;
        }catch (Exception e){
            System.out.println("회원 정보 조회 실패");
            e.printStackTrace();
        }

        return vo;
    }
}
