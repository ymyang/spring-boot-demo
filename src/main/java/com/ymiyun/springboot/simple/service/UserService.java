package com.ymiyun.springboot.simple.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymiyun.springboot.simple.domain.User;
import com.ymiyun.springboot.simple.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findUser(long userId) {
		return userRepository.findOne(userId);
	}
}
