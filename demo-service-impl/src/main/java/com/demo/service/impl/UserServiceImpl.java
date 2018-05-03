package com.demo.service.impl;

import org.springframework.stereotype.Service;

import com.demo.entity.User;
import com.demo.inner.base.serviceimpl.BaseServiceImpl;
import com.demo.mapper.UserMapper;
import com.demo.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserMapper> implements UserService{

	@Override
	public User selectByUsername(String username) {
		return null;
//		return mapper.selectByUsername(username);
	}

	
}
