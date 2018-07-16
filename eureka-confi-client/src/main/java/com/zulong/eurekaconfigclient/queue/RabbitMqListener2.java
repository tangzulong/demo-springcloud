package com.zulong.eurekaconfigclient.queue;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: demo-springcloud
 * @description: rabbitmq接收消息类
 * @author: Mr.Tang
 * @create: 2018-07-13 15:55
 **/
@Component
@RabbitListener(queues = "test-rabbitmq")
public class RabbitMqListener2 {
    @RabbitHandler
    public void rabbitListener(String content){
        System.out.println("2接收到的内容："+content);
    }
}
