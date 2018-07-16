package com.zulong.springcloud;

import com.zulong.springcloud.zuulFilter.AccessFilter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringCloudApplication
@EnableZuulProxy //开启Zuul网关
public class SpringbootApiGetwayApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SpringbootApiGetwayApplication.class).web(true).run(args);
	}



	/*@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}*/
}
