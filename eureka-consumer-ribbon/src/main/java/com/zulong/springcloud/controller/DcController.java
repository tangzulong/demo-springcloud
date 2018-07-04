package com.zulong.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author tangzulong
 * @file DcController.java
 * @date 2018-01-18
 * 15:36
 */
@RestController
public class DcController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/hello")
    public String dc() {
         //restTemplate.getForObject("http://eureka-client/dc", String.class);
        return "hello,我是eureka-consumer-ribbon";
    }
}
