package com.zulong.springcloud.controller;

import com.zulong.base.dto.LogDO;
import com.zulong.springcloud.client.DcClient;
import com.zulong.springcloud.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
