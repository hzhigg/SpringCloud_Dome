package com.demo.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.common.global.RtnResult;
import com.demo.user.client.UserClient;

/**
 * feign方式请求服务者示例
 * @author hzhigg
 * 2019年3月9日
 */
@RestController
@RequestMapping(produces=MediaType.APPLICATION_JSON_UTF8_VALUE)//以json格式返回，不写这个则返回xml格式
public class UserClientController {

	@Autowired
	private UserClient userClient;
	
	@GetMapping("/login")
	public RtnResult login(){
		return userClient.login();
	}
	
}
