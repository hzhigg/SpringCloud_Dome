package com.demo.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RefreshScope//刷新配置中心生效注解
@RestController
public class DcController {

	@Value("${server.port}")
	private String port;
	@Value("${name}")
    private  String name;
    @Value("${age}")
    private  String age;
    
	
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc() {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services+"=="+port);
        return services;
    }

    @ApiOperation("测试配置中心")
    @GetMapping("/testConfig")
    public String testConfig(){
    	 return "你好，我是"+name+",年龄："+age+"岁。";

    }
}