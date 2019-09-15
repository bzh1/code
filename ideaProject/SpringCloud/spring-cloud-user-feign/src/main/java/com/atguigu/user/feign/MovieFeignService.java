package com.atguigu.user.feign;

import com.atguigu.user.bean.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 1、@FeignClient：声明这个接口是一个具有远程调用功能的客户端接口
 * 2、需要远程调用的方法的签名拿来
 *      @GetMapping("/movie/get");说明调用hahahaMovie相当于是给SPRING-CLOUD-MOVIE服务发送get的movie/get请求
 *      public Movie hahahaMovie(Integer id)
 */
@FeignClient("SPRING-CLOUD-MOVIE")
public interface MovieFeignService {

    /**
     * 这个方法相当于调用远程接口的访问
     *
     * 每个请求参数都需要标注
     *
     * @param id
     * @return
     */
//    @GetMapping("/movie/get")
//    public Movie hahahaMovie(@RequestParam("id") Integer id);
    @GetMapping("/movie/get/{id}")
    public Movie getMovie(@PathVariable("id") Integer id);
}
