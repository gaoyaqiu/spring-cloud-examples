package com.gyq.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * 通过@EnableTurbine接口，激活对Turbine的支持.
 *
 * @auther gaoyaqiu
 */
@SpringBootApplication
@EnableTurbine
public class HystrixTurbineApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixTurbineApplication.class, args);
    }
}
