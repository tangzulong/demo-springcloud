package com.zulong.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * @Author Mr.Tang
 * @Description 搜索服务
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaElasticsearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaElasticsearchApplication.class, args);
	}
}



