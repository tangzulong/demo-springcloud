package com.zulong.springcloud.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by tzl on 2018/1/18.
 * @FeignClient("a") 通过这个@FeignClient注解来调用某个服务的接口  a 代表服务名称
 * 该调用实现了负载均衡
 */

@FeignClient(value = "eureka-client",fallback = DcClientImpl.class)
public interface DcClient {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String consumer();
}
