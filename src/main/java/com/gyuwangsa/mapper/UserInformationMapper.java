package com.gyuwangsa.mapper;

import com.gyuwangsa.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInformationMapper {
    //회원 정보 저장
    int insertUserJoin(UserVO vo) throws Exception;
    //회원 정보 조회
    UserVO selectUserInfo(String user_nm) throws Exception;
}
