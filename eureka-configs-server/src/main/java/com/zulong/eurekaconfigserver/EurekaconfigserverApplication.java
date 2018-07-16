package com.zulong.eurekaconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
@EnableEurekaClient
/**
 * cloud config server 实现配置化文件集中管理
 * 主要一种方式读取github上的文件，怎么读取看代码
 * 然后其他客户端服务通过application name直接调用
 */
public class EurekaconfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaconfigserverApplication.class, args);
	}
}
