package com.jeejava.spring.web.exception.handling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.jeejava.spring.web.exception.handling.entity")
@EnableJpaRepositories("com.jeejava.spring.web.exception.handling.repository")
@SpringBootApplication(scanBasePackages = "com.jeejava.spring.web.exception.handling")
public class SpringWebExceptionHandlingApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebExceptionHandlingApp.class, args);
	}

}
