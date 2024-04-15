package com.gyuwangsa.service;

import com.gyuwangsa.vo.RoleUserVO;

import java.util.List;

public interface RoleUserService {
    //권한 등록
    int insertRoleUserInfo(RoleUserVO vo) throws Exception;
    //해당 아이디 권한 검색
    List<String> selectRoleUserAuthorities(String user_id) throws Exception;
}
