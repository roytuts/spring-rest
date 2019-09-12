package com.roytuts.spring.rest.optional.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringRestController {

	@GetMapping(value = { "/hi/{name}", "/hi" })
	public ResponseEntity<String> getHi(@PathVariable(required = false) String name) {

		return new ResponseEntity<String>(
				"Hi " + (name == null || name.length() == 0 ? "Anonymous" : name) + ", Good Morning!", HttpStatus.OK);
	}

	@GetMapping(value = { "/hello/{name}", "/hello" })
	public ResponseEntity<String> getHello(@PathVariable Optional<String> name) {

		return new ResponseEntity<String>("Hello " + (name.isPresent() ? name.get() : "Anonymous") + ", Good Morning!",
				HttpStatus.OK);
	}

}
