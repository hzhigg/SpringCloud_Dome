package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
/**
 * @EnableDiscoveryClient与@EnableEurekaClient区别
 * 意思也就是spring cloud中discovery service有许多种实现（eureka、consul、zookeeper等等），
 * @EnableDiscoveryClient基于spring-cloud-commons, @EnableEurekaClient基于spring-cloud-netflix。
 *其实用更简单的话来说，就是如果选用的注册中心是eureka，那么就推荐@EnableEurekaClient，
 *如果是其他的注册中心，那么推荐使用@EnableDiscoveryClient。
 * @author hzhigg
 * 2019年3月12日
 */
@EnableConfigServer
//@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class ConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigApplication.class, args);
	}

}
