package com.atguigu.user.feign;

import com.atguigu.user.bean.Movie;
import com.atguigu.user.feign.fallback.MovieFeignServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 1、@FeignClient：声明这个接口是一个具有远程调用功能的客户端接口
 * 2、需要远程调用的方法的签名拿来
 *      @GetMapping("/movie/get");说明调用hahahaMovie相当于是给SPRING-CLOUD-MOVIE服务发送get的movie/get请求
 *      public Movie hahahaMovie(Integer id)
 *
 *  3、指定某个远程方法错误了怎么办；fallback指定错误回调
 *         MovieFeignService.getMovie()给我们去远程的SPRING-CLOUD-MOVIE服务发送/movie/get/{id}请求；获取结果
 *         一旦远程服务出问题；调用fallback指定的这个MovieFeignServiceFallBack类。
 *         找到刚才方法的实现，这个实现就是出现错误以后的容错实现（默认返回），
 *         没问题调用远程的，有问题使用默认实现的容错数据
 *
 */
@FeignClient(value = "SPRING-CLOUD-MOVIE",fallback = MovieFeignServiceFallBack.class)
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


//    @GetMapping("/movie/get/{id}")
//    public Movie getMovie(@PathVariable("id") Integer id);
}
