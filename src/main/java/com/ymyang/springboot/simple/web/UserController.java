package com.ymyang.springboot.simple.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ymyang.springboot.simple.Config;
import com.ymyang.springboot.simple.domain.User;
import com.ymyang.springboot.simple.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private Config config;
	
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String hello() {
		return "Hello " + config.appName;
	}
	
	@GetMapping("/users")
	public List<User> getUsers() {
		return userService.findAll();
	}
	
	@GetMapping("/user/{userId}")
	public User getUser(@PathVariable long userId) {
		return userService.findUser(userId);
	}

	@GetMapping("/users?key={key}")
	public List<User> User(@RequestParam("key") String key) {
		System.out.println("key:" + key);
		return userService.searchUser(key);
	}
	
	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		userService.saveUser(user);;
		return user;
	}
}
