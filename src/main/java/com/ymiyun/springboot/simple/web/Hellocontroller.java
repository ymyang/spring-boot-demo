package com.ymiyun.springboot.simple.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ymiyun.springboot.simple.Config;

@RestController
public class Hellocontroller {
	
	@Autowired
	private Config config;

	@GetMapping("/")
	public String hello() {
		return "Hello " + config.appName;
	}
}
