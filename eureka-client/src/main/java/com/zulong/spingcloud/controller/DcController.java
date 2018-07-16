package com.zulong.spingcloud.controller;

import org.springframework.retry.backoff.Sleeper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tangzulong
 * @file DcController.java
 * @date 2018-01-18
 * 14:54
 */
@RestController
public class DcController {

    /**
     *
     * @return
     */
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello() {
        return "hello,我是eur11eka-client";
    }
}
