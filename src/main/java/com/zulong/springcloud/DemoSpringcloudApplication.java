package com.zulong.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DemoSpringcloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringcloudApplication.class, args);
	}
}
