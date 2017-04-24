package com.ymiyun.springboot.simple.service;

import java.util.List;

import com.ymiyun.springboot.simple.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ymiyun.springboot.simple.domain.User;

public class UserServiceTest extends BaseTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void findAll() {
		List<User> users = userService.findAll();
		System.out.println(users.size());
	}
}
