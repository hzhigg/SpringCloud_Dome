package com.demo.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.common.base.controller.BaseController;
import com.common.global.LogicGroup;
import com.common.global.RtnResult;
import com.common.global.enums.RtnResultCode;
import com.common.util.page.ApiPageResult;
import com.common.util.page.PgeHeplerUtils;
import com.demo.user.entity.User;
import com.demo.user.service.UserService;
import com.demo.user.vo.UserVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="用户服务",tags={"用户服务"})
@RestController
@RequestMapping(value="/user",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController extends BaseController{

	@Autowired
	private UserService userService;
	
	@ApiOperation("未登入")
	@RequestMapping("/not-login")//未登入接口必须设置可以接受所有请求方式
	public RtnResult notLogin(){
		return RtnResult.Fail(RtnResultCode.NOT_LOGIN);
	}
	
	@ApiOperation("模拟登入接口")
	@GetMapping("/login")
	public RtnResult login(HttpServletRequest request){
		User user=userService.selectByPrimaryKey(1L);
		if(ObjectUtils.isEmpty(user)){
			return RtnResult.Fail(RtnResultCode.USERNAME_OR_PASS_ERROE);
		}
		request.getSession().setAttribute("user", user);
		return RtnResult.Success(user);
	}
	
	
	
	@ApiOperation("插入用户")
	@PostMapping("/insertSelective")
	public RtnResult insertSelective(@RequestBody @Validated({LogicGroup.addGroup.class}) User user){
		int count=userService.insertSelective(user);
		return RtnResult.Success(count);
	}
	
	
	@ApiOperation("根据id查询用户")
	@GetMapping("/getById")
	public RtnResult getById(Long id){
		User user=userService.selectByPrimaryKey(id);
		return RtnResult.Success(user);
	}
	
	@ApiOperation("根据条件查询用户")
	@GetMapping("/findList")
	public RtnResult findList(User user){
		List<User> users=userService.findList(user);
		return RtnResult.Success(users);
	}
	
	@ApiOperation("批量删除")
	@DeleteMapping("/deleteList")
	public RtnResult deleteList(@RequestBody List<Long> ids){
		int count=userService.deleteList(ids);
		return RtnResult.Success(count);
	}
	
	@ApiOperation("批量更新启动状态")
	@PutMapping("/updateIsValidList")
	public RtnResult updateIsValidList(@RequestBody List<Long> idS,@RequestParam Integer isValid ){
		int count=userService.updateIsValidList(idS, isValid);
		return RtnResult.Success(count);
	}
	
	@ApiOperation("更新启动状态")
	@PutMapping("/updateIsValid")
	public RtnResult updateIsValid(@RequestParam Long id,@RequestParam Integer isValid ){
		int count=userService.updateIsValid(id, isValid);
		return RtnResult.Success(count);
	}
	
	@ApiOperation("更新版本号")
	@PutMapping("/updateVersionAutoIncrease")
	public RtnResult updateVersionAutoIncrease(@RequestParam Long id){
		int count=userService.updateVersionAutoIncrease(id);
		return RtnResult.Success(count);
	}
	
	@ApiOperation("分页查询")
	@GetMapping("/getPage")
	public RtnResult getPage(UserVo vo){
		 Page<User> data = userService.getPage(vo);
	     ApiPageResult<User> result = new ApiPageResult<>();
	     PgeHeplerUtils.toApiPageResult(result, data);
	     return RtnResult.Success(result);
	}
	
}
