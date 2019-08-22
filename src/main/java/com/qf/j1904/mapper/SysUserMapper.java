package com.qf.j1904.mapper;

import com.qf.j1904.pojo.SysPermission;
import com.qf.j1904.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 提供权限系统对外访问的数据请求 by xxx
 */
@Mapper
public interface SysUserMapper {
    /**
     * 根据登录名查询用户信息
     * @param loginName 登录名
     * @return SysUser 用户对象信息
     */
    public SysUser findUserInfoByLoginName(@Param("loginName") String loginName);

    /**
     * 根据用户名查询该用户已分配的权限集合
     * @param loginName 登录名(用户名)
     * @return SysPermission对象的集合
     */
    public List<SysPermission> findPermissionByUserName(String loginName);
}
