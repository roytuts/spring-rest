package com.roytuts.spring.online.visitor.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.roytuts.spring.online.visitor.tracker.entity")
@EnableJpaRepositories(basePackages = "com.roytuts.spring.online.visitor.tracker.repository")
public class OnlineVisitorTracker {

	public static void main(String[] args) {
		SpringApplication.run(OnlineVisitorTracker.class, args);
	}

}
