package com.zulong.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
@MapperScan(basePackages = {"com.zulong.*.mapper"})
public class EurekaConsumerFeignApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaConsumerFeignApplication.class).web(true).run(args);
	}
}
