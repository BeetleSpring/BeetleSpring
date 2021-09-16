package com.beetle.onlinevideo.service.serviceImp;

import com.beetle.onlinevideo.dao.UserDao;
import com.beetle.onlinevideo.entity.User;
import com.beetle.onlinevideo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImp implements UserService {


    @Autowired
    UserDao dao;

    @Override
    public Integer register(User user) {
        return dao.insertUser(user);
    }

    @Override
    public User checkEmail(String email) {
        HashMap map = new HashMap();
        map.put("email",email);
        return dao.selectOne(map);

    }

    @Override
    public User loginCheck(User user) {
        HashMap map = new HashMap();
        map.put("email",user.getEmail());
        map.put("password",user.getPassword());

        return dao.selectOne(map);
    }

    @Override
    public PageInfo selectAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(dao.selectAll(),4);
    }

    @Override
    public Integer deleteUser(Integer uid) {
       return dao.updateFlag(uid);
    }

    @Override
    public User getUserById(Integer uid) {//后台系统 呈现给管理员修改用户信息页面所需要的信息
        HashMap map = new HashMap();
        map.put("id",uid);
        return dao.selectOne(map);
    }

    public Integer updateUser(User user){//后台系统 修改用户信息后的保存操作

        return dao.updateUser(user);
    }


}
