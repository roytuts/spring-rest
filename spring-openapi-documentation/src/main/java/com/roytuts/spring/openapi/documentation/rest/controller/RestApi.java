package com.roytuts.spring.openapi.documentation.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApi {

	@GetMapping("/")
	public ResponseEntity<String> greet() {
		return new ResponseEntity<String>("Hello World!", HttpStatus.OK);
	}

	@PostMapping("/greet")
	public ResponseEntity<String> greet(@RequestBody String name) {
		return new ResponseEntity<String>("Hello, " + name, HttpStatus.OK);
	}

}
