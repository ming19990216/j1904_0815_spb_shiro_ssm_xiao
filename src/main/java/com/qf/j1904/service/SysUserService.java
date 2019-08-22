package com.qf.j1904.service;

import com.qf.j1904.pojo.SysPermission;
import com.qf.j1904.pojo.SysUser;

import java.security.Permission;
import java.util.List;

/**
 *
 */
public interface SysUserService {
    public SysUser findUserByLoginName(String loginName);
    public List<SysPermission> findPermissionByLoginName(String loginName);
}
