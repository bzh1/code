package com.atguigu.user.dao;

import com.atguigu.user.bean.User;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class UserDao {

    public User getUser(Integer id){
        User user = new User();
        user.setId(id);
        user.setUsername(UUID.randomUUID().toString().substring(0,5));
        return user;
    }
}
