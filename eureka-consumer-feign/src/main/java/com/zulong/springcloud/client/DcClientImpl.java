package com.zulong.springcloud.client;

import org.springframework.stereotype.Component;

/**
 * @author tangzulong
 * @file DcClientImpl.java
 * @date 2018-01-18
 * 16:40
 */
@Component
public class DcClientImpl implements DcClient{

    @Override
    public String consumer() {
        return "进入断路器";
    }
}
