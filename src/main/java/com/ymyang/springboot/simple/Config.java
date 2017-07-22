package com.ymyang.springboot.simple;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Config {

	@Value("${app.name}")
	public String appName;
}
