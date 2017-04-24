package com.ymiyun.springboot.simple.web;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.ymiyun.springboot.simple.BaseTest;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class HelloControllerTest extends BaseTest {

	@Autowired
	private TestRestTemplate template;
	
	@Test
	public void hello() {
		String res = template.getForObject("/", String.class);
		System.out.println(res);
	}
}
