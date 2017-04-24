package com.ymiyun.springboot.simple.repository;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ymiyun.springboot.simple.BaseTest;
import com.ymiyun.springboot.simple.domain.User;

//@DataJpaTest
//@AutoConfigureTestDatabase(replace=Replace.NONE)
public class UserRepositoryTest extends BaseTest {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void findAll() {
		List<User> users = userRepository.findAll();
		System.out.println(users.size());
	}
}
