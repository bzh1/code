package com.atguigu.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * 1、导入hystrix的依赖
 * 2、开始hystrix容错功能；在配置文件中写
 *      feign:
 *          hystrix:
 *                  enabled: true
 *
 * 3、开启hystrix的断路保护器;
 */
@EnableCircuitBreaker
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudUserFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudUserFeignApplication.class, args);
    }


}
