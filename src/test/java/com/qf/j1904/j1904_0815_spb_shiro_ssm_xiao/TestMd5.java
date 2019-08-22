package com.qf.j1904.j1904_0815_spb_shiro_ssm_xiao;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

public class TestMd5 {
    @Test
    public void testmd51(){
        String source="1234";
        Md5Hash hash = new Md5Hash(source);
        String s = hash.toString();
        System.out.println(s);
//        System.out.println(hash.toBase64());
        String salt="qwe";
        Md5Hash md5Hash = new Md5Hash(source, salt);
        System.out.println("salt:"+salt+" ="+md5Hash.toHex());
        int hashIterations=1;
        Md5Hash md5Hash1 = new Md5Hash(source, salt, 1);
    }
}
