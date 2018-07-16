package com.zulong.springcloud.client;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author tangzulong
 * @file DcClientImpl.java
 * @date 2018-01-18
 * 16:40
 */
@Component
public class DcClientImpl implements DcClient{

    private Logger logger= LogManager.getLogger(DcClientImpl.class);

    @Override
    public String consumer() {
        logger.error(String.format("调用%s服务的%s接口失败！","eureka-client","/hello"));
        return "进入断路器";
    }
}
