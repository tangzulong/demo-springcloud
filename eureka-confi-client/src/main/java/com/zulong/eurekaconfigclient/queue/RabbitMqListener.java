package com.zulong.eurekaconfigclient.queue;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: tzl
 * @Date: 2018/7/13 11:54
 * @Description:
 */
@Component
@RabbitListener(queues = "test-rabbitmq")
public class RabbitMqListener {

    @RabbitHandler
    public void rabbitListener(String content){
        System.out.println("接收到的内容："+content);
    }
}
