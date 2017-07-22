package com.ymyang.springboot.simple.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ymyang.springboot.simple.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

	@Query("select u from User u where u.name like %:name%")
	List<User> search(@Param("name") String name);
}
