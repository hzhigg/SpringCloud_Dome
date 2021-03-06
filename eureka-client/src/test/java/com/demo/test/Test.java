package com.demo.test;

import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.common.util.DozerUtils;
import com.demo.user.entity.User;
import com.demo.user.service.UserService;
import com.demo.user.vo.UserVo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

	@Autowired
	private UserService userService;
	
	@org.junit.Test
	public void testCopy(){
		User source=new User();
		source.setEmail("1233@qq.com");
		User back=new User();
		BeanUtils.copyProperties(source, back);
		System.out.println(JSON.toJSONString(back));
	}
	
	@org.junit.Test
	public void testDozer(){
		UserVo vo=new UserVo();
		vo.setEmail("123@qq.com");
		User user=DozerUtils.map(vo, User.class);
		System.out.println(JSON.toJSON(user));
	}
	
	@org.junit.Test
	public void test(){
		User user=userService.selectByPrimaryKey(1L);
		System.out.println(JSON.toJSONString(user));
	}
}
