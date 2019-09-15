package com.atguigu.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * 作业；
 * 1）、创建一个注册中心
 * 2）、创建一个用户服务，并注册到注册中心
 * 3）、创建一个电影服务，注册到注册中心
 * 4）、尝试整合 Ribbon。完成用户服务远程调用电影服务
 * 5）、尝试整合 Feign，完成用户服务远程调用电影服务
 * 6）、Ribbon 整合Hystrix对服务容错，返回默认数据（兜底数据）
 * 7）、Feign 整合 Hystrix 对服务容错，返回默认数据（兜底数据）
 * 8）、整合HystrixDashBoard监控服务熔断过程。
 *
 *
 *
 * 1、服务监控只需要引入actuator;
 *
 * 如何监控服务的熔断；
 * 1）、导入actuator；开启应用监控功能，并监控所有指标
 *      management:
 *           endpoints:
 *               web:
 *                  exposure:
 *                      include: '*'
 * 2）、导入spring-cloud-starter-netflix-hystrix-dashboard;并开启可视化监控功能；
 * 3)、可以监控
 */
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudDashBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDashBoardApplication.class, args);
    }


}
