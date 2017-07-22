package com.ymyang.springboot.simple.datasource;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactoryPrimary",
        transactionManagerRef="transactionManagerPrimary",
        basePackages= { "com.ymyang.springboot.simple.repository"})
public class PrimaryConfig {

	 	@Autowired
	    @Qualifier("primaryDataSource")
	    private DataSource primaryDataSource;

	    @Bean(name = "entityManagerPrmary")
	    @Primary
	    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
	        return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
	    }

	    @Bean(name = "entityManagerFactoryPrimary")
	    @Primary
	    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary(EntityManagerFactoryBuilder builder) {
	        return builder
	                .dataSource(primaryDataSource)
	                .properties(getVendorProperties(primaryDataSource))
	                .packages("com.ymyang.springboot.simple.domain")
	                .persistenceUnit("PrimaryPersistenceUnit")
	                .build();
	    }

	    @Autowired
	    private JpaProperties jpaProperties;

	    private Map<String, String> getVendorProperties(DataSource dataSource) {
	        return jpaProperties.getHibernateProperties(dataSource);
	    }

	    
	    @Bean(name = "transactionManagerPrimary")
	    @Primary
	    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
	        return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
	    }
	 
}
