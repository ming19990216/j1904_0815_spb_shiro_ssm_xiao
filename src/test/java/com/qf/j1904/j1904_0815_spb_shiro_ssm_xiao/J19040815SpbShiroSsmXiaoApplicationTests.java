package com.qf.j1904.j1904_0815_spb_shiro_ssm_xiao;

import com.qf.j1904.mapper.SysUserMapper;
import com.qf.j1904.pojo.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class J19040815SpbShiroSsmXiaoApplicationTests {
    @Autowired
    SysUserMapper sysUserMapper;
    @Test
    public void contextLoads() {
        SysUser test = sysUserMapper.findUserInfoByLoginName("test");
        System.out.println(test);
    }

}
