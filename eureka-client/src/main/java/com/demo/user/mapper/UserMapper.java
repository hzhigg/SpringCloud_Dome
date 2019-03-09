package com.demo.user.mapper;

import com.common.base.mapper.BaseMapper;
import com.demo.user.entity.User;
import com.github.pagehelper.Page;

public interface UserMapper extends BaseMapper<User>{

	Page<User> findListPage(User user);
   
}