package com.roytuts.java.spring.concurrency.service.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ServiceApiApp {

	public static void main(String[] args) {
		SpringApplication.run(ServiceApiApp.class, args);
	}

	@GetMapping("/msg")
	public ResponseEntity<String> sayHello() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Hello", HttpStatus.OK);
	}

}
