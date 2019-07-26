package com.xx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xx.entity.User;
import com.xx.mapper.UserMapper;
import com.xx.service.UserService;

import java.util.List;


@Transactional
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	public User loginByUserId(String snum) {
		return userMapper.loginByUserId(snum);
	}

	@Override
	public List<User> selectAllUsers() {
		return userMapper.selectAllUsers();
	}

	@Override
	public User selectUserById(Integer userid) {
		return userMapper.selectById(userid);
	}

	@Override
	public void register(User user) {
		userMapper.register(user);
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

	@Override
	public User selectUser(User user) {
		return userMapper.selectUser(user);
	}


}
