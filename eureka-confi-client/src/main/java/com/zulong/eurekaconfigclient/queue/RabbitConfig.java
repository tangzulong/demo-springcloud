package com.zulong.eurekaconfigclient.queue;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: tzl
 * @Date: 2018/7/13 11:46
 * @Description:
 */
@Configuration
public class RabbitConfig {

    public static  String QUEUE="test-rabbitmq";
    @Bean
    public Queue Queue() {
        return new Queue(RabbitConfig.QUEUE);
    }
}
