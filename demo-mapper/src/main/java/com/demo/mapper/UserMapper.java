package com.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.demo.entity.User;
import com.demo.inner.base.mapper.BaseMapper;

@Mapper
public interface UserMapper extends BaseMapper<User>{

	public User selectByUsername(String username);
	
}
