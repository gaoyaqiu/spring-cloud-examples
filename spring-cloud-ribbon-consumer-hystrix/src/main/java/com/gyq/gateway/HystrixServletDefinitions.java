package com.gyq.gateway;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 解决Unable to connect to Command Metric Stream.
 *
 * @auther gaoyaqiu
 */
@Configuration
public class HystrixServletDefinitions {
    @Bean(name = "hystrixRegistrationBean")
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean registration = new ServletRegistrationBean(
                new HystrixMetricsStreamServlet(), "/hystrix.stream");
        registration.setName("hystrixServlet");
        registration.setLoadOnStartup(1);
        return registration;
    }
}
