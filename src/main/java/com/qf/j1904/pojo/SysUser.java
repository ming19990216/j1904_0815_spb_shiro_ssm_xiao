package com.qf.j1904.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 对用户信息封装 by xxx
 */
@Data
public class SysUser implements Serializable {
    private long userId;//用户id
    private String loginName;//登录名
    private String password;//密码（密文）
    private int state;//状态：1表示用户有效 0表示用户被禁用户
    private Date createTime;// 用户创建时间
    private String realname;//真实姓名

}
