package com.gyq.gateway;

import com.gyq.gateway.filter.PasswordFilter;
import com.gyq.gateway.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * 通过@EnableTurbine接口，激活对Turbine的支持.
 * 访问地址: http://localhost:9006/eureka-client/hello?token=1&&password=123456
 *
 * @auther gaoyaqiu
 */
@EnableZuulProxy
@SpringBootApplication
public class ApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }

    @Bean
    public PasswordFilter PasswordFilter() {
        return new PasswordFilter();
    }
}
