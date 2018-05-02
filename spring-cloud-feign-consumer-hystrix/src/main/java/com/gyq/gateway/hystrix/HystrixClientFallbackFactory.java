package com.gyq.gateway.hystrix;

import com.gyq.gateway.client.HomeClient;
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
