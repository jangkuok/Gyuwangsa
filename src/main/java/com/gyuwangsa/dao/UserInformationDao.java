package com.gyuwangsa.dao;

import com.gyuwangsa.vo.UserVO;

public interface UserInformationDao {
    
    //회원 정보 저장
    int insertUserJoin(UserVO vo) throws Exception;
    //회원 정보 조회
    UserVO selectUserInfo(String user_nm) throws Exception;
}
