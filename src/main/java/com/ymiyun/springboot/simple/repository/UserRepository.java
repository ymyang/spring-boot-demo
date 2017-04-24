package com.ymiyun.springboot.simple.repository;

import com.ymiyun.springboot.simple.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

}
