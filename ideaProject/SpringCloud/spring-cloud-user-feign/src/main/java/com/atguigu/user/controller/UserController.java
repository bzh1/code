package com.atguigu.user.controller;

import com.atguigu.user.bean.Movie;
import com.atguigu.user.bean.Order;
import com.atguigu.user.bean.User;
import com.atguigu.user.feign.MovieFeignService;
import com.atguigu.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @Autowired
    MovieFeignService movieFeignService;

    // user/get?id=1
    @GetMapping("/user/get")
    public User getUserInfo(Integer id){

        return userService.getLoginUser(id);
    }

    /**
     *
     * @param id  电影id
     * @return
     */
    @GetMapping("/buy/movie")
    public Order buyNewMovie(Integer id){
        //1、获取当前登录的用户
        User loginUser = userService.getLoginUser(5);
        //2、获取最新的电影
        Movie movie = movieFeignService.getMovie(id);

        //Movie movie  = movieService.getMovie();

        Order order = new Order();
        order.setUser(loginUser);
        order.setMovie(movie);
        order.setOrderSn(UUID.randomUUID().toString().replace("-",""));
        order.setPrice(100);
        return order;
    }
}
