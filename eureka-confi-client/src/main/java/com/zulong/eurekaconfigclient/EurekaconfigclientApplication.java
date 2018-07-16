package com.zulong.eurekaconfigclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaconfigclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaconfigclientApplication.class, args);
	}
}
