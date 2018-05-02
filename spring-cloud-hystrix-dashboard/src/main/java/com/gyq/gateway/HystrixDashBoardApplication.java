package com.gyq.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @auther gaoyaqiu
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashBoardApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashBoardApplication.class, args);
    }
}
