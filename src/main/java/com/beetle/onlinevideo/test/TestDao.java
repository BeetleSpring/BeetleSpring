package com.beetle.onlinevideo.test;

import cn.hutool.core.date.DateUtil;
import com.beetle.onlinevideo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;

public class TestDao {
    @Autowired
    static UserDao userDao;

    public static void main(String[] args) {
        //System.out.println(userDao);
        Date date = new Date();
        System.out.println(DateUtil.now());

    }
}
