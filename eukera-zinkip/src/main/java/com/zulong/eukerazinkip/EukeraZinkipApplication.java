package com.zulong.eukerazinkip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
/**
 * Description:可以用来收集各个服务请求链路的跟踪数据，并通过rest api来辅助我们查询数据来实现对分布式系统的监控，从而更好，更快的找到问题之根源
 * zipkin分为服务端和客户端
 * 		将客户端监控到的信息发送到zipkin_server
 * 		客户端添加jar依赖和相应的配置：
	 * 		spring.zipkin.base-url=http://localhost:1106   --指向zipkin_server
			spring.sleuth.sampler.percentage=1.0
 */
public class EukeraZinkipApplication {

	public static void main(String[] args) {
		SpringApplication.run(EukeraZinkipApplication.class, args);
	}
}
