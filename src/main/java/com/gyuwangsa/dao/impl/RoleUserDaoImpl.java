package com.gyuwangsa.dao.impl;

import com.gyuwangsa.dao.RoleUserDao;
import com.gyuwangsa.mapper.RoleUserMapper;
import com.gyuwangsa.vo.RoleUserVO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("roleUserDao")
public class RoleUserDaoImpl implements RoleUserDao {

    @Resource(name= "roleUserMapper")
    private RoleUserMapper roleUserMapper;

    //권한 등록
    @Override
    public int insertRoleUserInfo(RoleUserVO vo) throws Exception {
        System.out.println("===> <권 한> MyBatis로 insertRoleEmpInfo() 기능 처리");
        return roleUserMapper.insertRoleUserInfo(vo);
    }

    //해당 아이디 권한 검색
    @Override
    public List<String> selectRoleUserAuthorities(String user_id) throws Exception {
        System.out.println("===> <권 한> MyBatis로 selectRoleUserAuthorities() 기능 처리");
        return roleUserMapper.selectRoleUserAuthorities(user_id);
    }
}
