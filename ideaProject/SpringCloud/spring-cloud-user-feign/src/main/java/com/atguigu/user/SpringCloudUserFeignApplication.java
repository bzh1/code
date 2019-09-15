package com.atguigu.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * 1、引入feign依赖
 * 2、开启服务发现功能  @EnableDiscoveryClient
 * 3、开启feign声明式客户端调用功能；
 *      @EnableFeignClients
 * 4、
 *
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudUserFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudUserFeignApplication.class, args);
    }


}
