package com.gyq.gateway;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 消费者方法.
 *
 * @auther gaoyaqiu
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "defaultStores")
    @GetMapping("/hello")
    public String hello() {
        return restTemplate.getForEntity("http://eureka-client/hello", String.class).getBody();
    }

    public String defaultStores() {
        return "Ribbon + hystrix + defaultStores ,提供者服务挂了";
    }


    @HystrixCommand(fallbackMethod = "defaultStores3")
    @GetMapping("/hello3")
    public String hello3() {
        return restTemplate.getForEntity("http://eureka-client-3/hello3", String.class).getBody();
    }

    public String defaultStores3() {
        return "Ribbon + hystrix + defaultStores3 ,提供者服务挂了";
    }
}
