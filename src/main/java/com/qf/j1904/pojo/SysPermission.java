package com.qf.j1904.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 对系统权限封装 by xxx
 */
@Data
public class SysPermission implements Serializable {
    private long permission_id;//权限id
    private String per_name;//权限名称
    private String menu_name;//菜单名
    private String memu_type;//菜单分类
    private String menu_url;//菜单接口url
    private String menu_code;//菜单编号
    private String parent_code;//父编号
    private String per_desc;//权限描述
    private String if_vilid;//是否有效

}
