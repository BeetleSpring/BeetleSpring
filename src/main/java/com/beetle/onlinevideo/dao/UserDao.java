package com.beetle.onlinevideo.dao;

import com.beetle.onlinevideo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;


public interface UserDao {

//    public int insertUser(User user){
//        return 1;
//    }
    int insertUser(User user);

    User selectOne(HashMap map);

    Integer updateVip(Integer uid);

    List<User> selectAll();

    Integer updateFlag(Integer uid);

    Integer updateUser(User user);
}
