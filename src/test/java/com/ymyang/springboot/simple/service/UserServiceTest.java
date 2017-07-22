package com.ymyang.springboot.simple.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ymyang.springboot.simple.BaseTest;
import com.ymyang.springboot.simple.domain.User;
import com.ymyang.springboot.simple.service.UserService;

public class UserServiceTest extends BaseTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void findAll() {
		List<User> users = userService.findAll();
		System.out.println(users.size());
	}
	
	@Test
	public void saveUser() {
		User user = new User();
		user.setId(12);
		user.setName("user8");
		userService.saveUser(user);;
	}
}
