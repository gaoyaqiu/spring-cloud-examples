package com.gyq.gateway.controller;

import com.gyq.gateway.client.HomeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 调用提供者的"hello"方法.
 *
 * @auther gaoyaqiu
 */
@RestController
public class ConsumerController {

    @Autowired
    private HomeClient homeClient;

    @GetMapping("/hello")
    public String h() {
        return homeClient.hello();
    }
}
