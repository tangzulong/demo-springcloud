package com.zulong.springcloud;

import com.zulong.springcloud.queue.RabbitConfig;
import com.zulong.springcloud.queue.RabbitMqSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaConsumerFeignApplicationTests {

	@Autowired
	private RabbitMqSender rabbitMqSender;

	@Test
	public void contextLoads() {
		rabbitMqSender.send(RabbitConfig.QUEUE,"你好啊,client服务");
	}

}
