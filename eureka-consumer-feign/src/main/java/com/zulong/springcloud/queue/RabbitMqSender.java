package com.zulong.springcloud.queue;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: tzl
 * @Date: 2018/7/13 11:47
 * @Description:
 */

@Component
public class RabbitMqSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String queueName,String content){
        amqpTemplate.convertAndSend(queueName,content);
    }
}
