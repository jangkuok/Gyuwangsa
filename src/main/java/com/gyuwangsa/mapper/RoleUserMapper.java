package com.gyuwangsa.mapper;

import com.gyuwangsa.vo.RoleUserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleUserMapper {
    //권한 등록
    int insertRoleUserInfo(RoleUserVO vo) throws Exception;

    //해당 아이디 권한 검색
    List<String> selectRoleUserAuthorities(String user_id) throws Exception;
}
