package com.ymyang.springboot.simple.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.ymyang.springboot.simple.BaseTest;
import com.ymyang.springboot.simple.domain.User;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class UserControllerTest extends BaseTest {

	@Autowired
	private TestRestTemplate template;
	
	@Test
	public void hello() {
		String res = template.getForObject("/", String.class);
		System.out.println(res);
	}
	
	@Test
	public void search() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("key", "name");
		List<User> res = template.getForObject("/users", ArrayList.class, params);
		System.out.println(res.size());
	}
	
	@Test
	public void saveUser() {
		User user = new User();
		user.setId(9);
		user.setName("user09");
		User res = template.postForObject("/user", user, User.class);
		System.out.println(res.getName());
	}
}
