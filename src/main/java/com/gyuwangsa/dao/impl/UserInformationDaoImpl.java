package com.gyuwangsa.dao.impl;

import com.gyuwangsa.dao.UserInformationDao;
import com.gyuwangsa.mapper.UserInformationMapper;
import com.gyuwangsa.vo.UserVO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("userInformationDao")
public class UserInformationDaoImpl implements UserInformationDao {

    @Resource(name = "userInformationMapper")
    private UserInformationMapper mapper;

    //회원 정보 저장
    @Override
    public int insertUserJoin(UserVO vo) throws Exception {
        System.out.println("===> <회 원> MyBatis로 insertUserJoin() 기능 처리");
        return mapper.insertUserJoin(vo);
    }

    //회원 정보 조회
    @Override
    public UserVO selectUserInfo(String user_nm) throws Exception {
        System.out.println("===> <회 원> MyBatis로 selectUserInfo() 기능 처리");
        return mapper.selectUserInfo(user_nm);
    }
}
