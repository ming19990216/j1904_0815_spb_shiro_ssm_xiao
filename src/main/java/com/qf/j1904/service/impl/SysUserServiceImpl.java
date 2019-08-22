package com.qf.j1904.service.impl;

import com.qf.j1904.mapper.SysUserMapper;
import com.qf.j1904.pojo.SysPermission;
import com.qf.j1904.pojo.SysUser;
import com.qf.j1904.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService{
    @Resource
    private SysUserMapper userMapper;
    @Override
    public SysUser findUserByLoginName(String loginName) {
        SysUser sysUser = userMapper.findUserInfoByLoginName(loginName);
        return sysUser;
    }

    @Override
    public List<SysPermission> findPermissionByLoginName(String loginName) {
        List<SysPermission> permissionByUserName = userMapper.findPermissionByUserName(loginName);
        return permissionByUserName;
    }
}
