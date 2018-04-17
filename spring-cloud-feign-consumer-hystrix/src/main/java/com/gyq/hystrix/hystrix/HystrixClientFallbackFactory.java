package com.gyq.hystrix.hystrix;

import com.gyq.hystrix.client.HomeClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @auther gaoyaqiu
 */
@Component
public class HystrixClientFallbackFactory implements FallbackFactory<HomeClient> {
    @Override
    public HomeClient create(Throwable cause) {
        return () -> "feign + hystrix ,提供者服务挂了";
    }
}
