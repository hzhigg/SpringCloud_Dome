package com.demo.user.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.common.global.RtnResult;

@FeignClient(name="eureka-client")
public interface UserClient {

	@GetMapping("/user/login")
	RtnResult login();
	
}
