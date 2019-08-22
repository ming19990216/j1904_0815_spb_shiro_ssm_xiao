package com.qf.j1904.shiro;

import com.qf.j1904.pojo.SysPermission;
import com.qf.j1904.pojo.SysUser;
import com.qf.j1904.service.SysUserService;
import com.sun.tools.classfile.Opcode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class MyRealm extends AuthorizingRealm {
    @Autowired//注入业务实现
    private SysUserService sysUserService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Object principal = principalCollection.getPrimaryPrincipal();
        if (!StringUtils.isEmpty(principal)){
                String loginName=(String)principal;
                List<SysPermission> permissionName = sysUserService.findPermissionByLoginName(loginName);
                Set<String> perms=new HashSet<>();
                for (SysPermission perm:permissionName) {
                    String per_name = perm.getPer_name();
                    perms.add(per_name);
                }
                SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
                authorizationInfo.setStringPermissions(perms);
                return authorizationInfo;
        }
        return null;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取身份信息
        Object principal = token.getPrincipal();
        if (!StringUtils.isEmpty(principal)){
            String loginName=(String) principal;
        //调用方法查询用户信息
            SysUser sysUser = sysUserService.findUserByLoginName(loginName);
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(loginName, sysUser.getPassword(), getName());
            return authenticationInfo;
        }
        return null;
    }
}
