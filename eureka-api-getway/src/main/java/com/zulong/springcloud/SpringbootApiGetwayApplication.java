package com.zulong.springcloud;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringCloudApplication
@EnableZuulProxy //开启Zuul网关
public class SpringbootApiGetwayApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SpringbootApiGetwayApplication.class).web(true).run(args);
	}
}
