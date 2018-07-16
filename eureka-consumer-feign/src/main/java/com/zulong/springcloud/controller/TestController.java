package com.zulong.springcloud.controller;

import com.netflix.discovery.converters.Auto;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.zulong.base.dto.LogDO;
import com.zulong.springcloud.client.DcClient;
import com.zulong.springcloud.queue.RabbitConfig;
import com.zulong.springcloud.queue.RabbitMqSender;
import com.zulong.springcloud.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author tangzulong
 * @file TestController.java
 * @date 2018-01-18
 * 16:00
 */
@RestController
@RequestMapping("/user-service")
public class TestController {

    @Autowired
    DcClient dcClient;

    @Value("${from}")
    String str;

    @Autowired
    private RabbitMqSender rabbitMqSender;

    @Autowired
    private LogService logService;


    @GetMapping("/getClientData")
    public String getClientData(){

        return dcClient.consumer();
    }

    @RequestMapping(value = "/getLogDo",method = RequestMethod.GET)
    public LogDO getLogDo(@RequestParam("id") String id){
        LogDO logDO=logService.getList(id);
        return logDO;
    }

    @RequestMapping(value = "/testConfig",method = RequestMethod.GET)
    public String testConfig(){
        return str;
    }

    @RequestMapping(value = "/testRabbitMQ",method = RequestMethod.GET)
    public void testRabbitMQ(){

        rabbitMqSender.send(RabbitConfig.QUEUE,"你好啊,client服务");
    }

}
