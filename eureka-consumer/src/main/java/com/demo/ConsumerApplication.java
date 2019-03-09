package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


//启用feign进行远程调用
@EnableFeignClients
//启用服务注册与发现
@EnableDiscoveryClient
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})//过滤连接数据库操作
@SpringBootApplication
public class ConsumerApplication {
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

}
