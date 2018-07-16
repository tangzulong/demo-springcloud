package com.zulong.eurekaconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: tzl
 * @Date: 2018/7/5 10:32
 * @Description:
 */
@RestController
public class TestConfigController {

    @Value("${from}")
    private String str;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return str;
    }
}
