package com.demo.service;

import com.demo.entity.User;
import com.demo.inner.base.service.BaseService;
import com.demo.mapper.UserMapper;

public interface UserService extends BaseService<User, UserMapper>{

	
	public User selectByUsername(String username);
	
}
