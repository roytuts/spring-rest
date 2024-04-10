package com.roytuts.springrestretry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
public class ClientApp {

	public static void main(String[] args) {
		SpringApplication.run(ClientApp.class, args);
	}

}
