package com.roytuts.spring.online.visitor.tracker.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@GetMapping("/")
	public ResponseEntity<String> home() {
		return new ResponseEntity<String>("Welcome to User Activity Logging", HttpStatus.OK);
	}

	@GetMapping("/hello/{name}")
	public ResponseEntity<String> greet(@PathVariable String name) {
		return new ResponseEntity<String>("Hello, " + name, HttpStatus.OK);
	}

	@GetMapping("/login")
	public ResponseEntity<String> login() {
		return new ResponseEntity<String>("Hello, this is a secured page", HttpStatus.OK);
	}

}
