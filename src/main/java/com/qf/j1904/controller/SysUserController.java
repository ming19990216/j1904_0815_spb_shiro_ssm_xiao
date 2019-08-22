package com.qf.j1904.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SysUserController {
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String showLoginForm(){
        return "login";
    }

    @RequestMapping(value = "/dealLogin",method = RequestMethod.POST)
    public String login(@RequestParam("loginName")String loginName
                        ,@RequestParam("password")String password){
        /**
         * 1、查询用户是否存在
         * 2、用户存在查出用户信息，比对凭证
         * 3、对输入的凭证信息加密与查出的凭证比较
         * 4、凭证一致，根据用户名查询该用户的权限
         * 5、将用户信息进行脱密后和权限信息存储(session)
         * 6、返回登陆信息
         * 使用shiro后，这些步骤都用shiro可以完成
         */
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(loginName,password);
            subject.login(token);
            if (subject.isAuthenticated()){
                System.out.println("成功");
                return "main";
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        return "login";
    }

    /**
     * 当用户权限不足时，访问的页面
     * @return
     */
    @RequestMapping("/unOauth")
    public String showUnOauth(){
        return "unauth";
    }
    //用户登出时
    @RequestMapping("/logout")
    public String logout(){
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            return "login";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "login";
    }
    //普通用户有权访问的模块
    @RequiresPermissions(value = {"user_edit"})
    @RequestMapping("/one")
    public String one(){
        return "one";
    }
    @RequiresPermissions(value = {"user_forbidden"})
    @RequestMapping("/two")
    public String two(){
        return "two";
    }
}
