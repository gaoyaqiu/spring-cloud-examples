package com.gyq.dashboard.client;

import com.gyq.dashboard.hystrix.HystrixClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 指定该接口需要调用的提供者服务名"eureka=client".
 *
 * @auther gaoyaqiu
 */
@FeignClient(value = "eureka-client", fallbackFactory = HystrixClientFallbackFactory.class)
public interface HomeClient {

    @GetMapping("/hello")
    String hello();
}
