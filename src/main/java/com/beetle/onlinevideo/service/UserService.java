package com.beetle.onlinevideo.service;

import com.beetle.onlinevideo.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;

public interface UserService {

    //注册账号
    Integer register(User user);
    //根据传输过来的email 确定数据库内是否已存在
    User checkEmail(String email);

    //登录验证
    User loginCheck(User user);

    //查询所有用户

    PageInfo selectAll(Integer pageNum, Integer pageSize);

    //删除指定用户
    Integer deleteUser(Integer uid);

    User getUserById(Integer uid);

    Integer updateUser(User user);
}
