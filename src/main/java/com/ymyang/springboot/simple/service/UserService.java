package com.ymyang.springboot.simple.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymyang.springboot.simple.domain.User;
import com.ymyang.springboot.simple.repository.UserRepository;

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
	
	public List<User> searchUser(String key) {
		return userRepository.search(key);
	}
	
	public void saveUser(User user) {
		userRepository.save(user);
	}
}
