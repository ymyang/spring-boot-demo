package com.ymiyun.springboot.simple.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ymiyun.springboot.simple.domain.User;
import com.ymiyun.springboot.simple.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userservice;

	@GetMapping("/users")
	public List<User> getUsers() {
		return userservice.findAll();
	}
	
	
	@GetMapping("/user/{userId}")
	public User getUser(@PathVariable long userId) {
		return userservice.findUser(userId);
	}
}
