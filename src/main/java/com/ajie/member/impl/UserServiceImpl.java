package com.ajie.member.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ajie.mapper.BaseUserMapper;
import com.ajie.member.User;
import com.ajie.member.UserService;
import com.ajie.pojo.BaseUser;

/**
 * @author niezhenjie
 * 
 */
@Service
public class UserServiceImpl implements UserService{

	@Resource
	private BaseUserMapper userMapper;
	
	public User getUser(int id) {
		BaseUser user = userMapper.selectByPrimaryKey(1);
		return user;
	}

}
