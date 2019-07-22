package com.jeejava.spring.boot.rest.caching.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableCaching
@SpringBootApplication(scanBasePackages = "com.jeejava.spring.boot.rest.caching")
@EntityScan("com.jeejava.spring.boot.rest.caching.entity")
@EnableJpaRepositories("com.jeejava.spring.boot.rest.caching.repository")
public class SpringRestCachingApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestCachingApp.class, args);
	}

}
