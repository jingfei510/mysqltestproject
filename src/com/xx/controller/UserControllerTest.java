package com.xx.controller;

import com.xx.entity.User;
import com.xx.utils.MD5;
import org.junit.Test;
import org.apache.commons.codec.digest.DigestUtils;


import static org.junit.Assert.*;

public class UserControllerTest {

    @Test
    public void login() {
    }

    @Test
    public void register() throws Exception {
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123456");
        String s = MD5.md5(user.getPassword(), user.getUsername());
        System.out.println(s);
    }
}