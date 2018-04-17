package com.gyq.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @auther gaoyaqiu
 */
@EnableHystrix
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class FeignConsumerHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerHystrixApplication.class, args);
    }
}
