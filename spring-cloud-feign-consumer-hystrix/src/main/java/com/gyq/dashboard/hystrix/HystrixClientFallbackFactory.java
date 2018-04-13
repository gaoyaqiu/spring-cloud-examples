package com.gyq.dashboard.hystrix;

import com.gyq.dashboard.client.HomeClient;
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
