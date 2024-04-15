package com.gyuwangsa.service.impl;

import com.gyuwangsa.dao.RoleUserDao;
import com.gyuwangsa.service.RoleUserService;
import com.gyuwangsa.vo.RoleUserVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("roleEmpService")
public class RoleUserServiceImpl implements RoleUserService {

    @Resource(name="roleUserDao")
    private RoleUserDao roleUserDao;

    //권한 등록
    @Override
    public int insertRoleUserInfo(RoleUserVO vo) throws Exception {
        System.out.println("===> <권 한> Service insertRoleEmpInfo() 기능 처리");
        return roleUserDao.insertRoleUserInfo(vo);
    }

    @Override
    public List<String> selectRoleUserAuthorities(String user_id) throws Exception {
        System.out.println("===> <권 한> Service selectRoleUserAuthorities() 기능 처리");
        return roleUserDao.selectRoleUserAuthorities(user_id);
    }
}
