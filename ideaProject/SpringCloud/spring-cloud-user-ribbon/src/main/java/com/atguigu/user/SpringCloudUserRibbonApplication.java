package com.atguigu.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 * @EnableDiscoveryClient：启动客户端发现功能；
 *
 * 1、导入ribbon，开启远程发现功能
 * 2、给容器中放一个 RestTemplate；远程调用功能;@LoadBalanced
 * 3、RestTemplate给目标服务发请求要数据即可；
 *
 *
 * 1)、容错；
 *      1）、导入hystrxi;spring-cloud-starter-netflix-hystrix
 *      2）、开启熔断保护功能 @EnableCircuitBreaker
 *      3）、
 *
 */
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudUserRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudUserRibbonApplication.class, args);
    }

    /**
     * RestTemplate：可以发送请求
     * @return
     */
    @LoadBalanced  //负载均衡；告诉Ribbon负载均衡的去调用其他
    @Bean
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }

}
