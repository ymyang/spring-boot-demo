package com.ymyang.springboot.simple.datasource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

@Configuration
public class DataSorceConfig {

	@Bean
	@Qualifier("primaryDataSource")
	@Primary
	public DataSource ssoDataSource(Environment env) {
		return DruidDataSourceBuilder.create().build(env, "spring.datasource.primary.");
	}

}
