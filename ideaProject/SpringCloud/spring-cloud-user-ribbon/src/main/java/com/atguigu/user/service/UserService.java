package com.atguigu.user.service;

import com.atguigu.user.bean.User;
import com.atguigu.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User getLoginUser(Integer id){
        User user = userDao.getUser(id);

        return user;
    }
}
