package com.roytuts.spring.boot.rest.caching.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.roytuts.spring.boot.rest.caching.entity.User;
import com.roytuts.spring.boot.rest.caching.service.UserService;

@RestController
public class UserRestController {

	@Autowired
	private UserService service;

	@GetMapping("/users")
	public ResponseEntity<List<User>> getUserList() {
		return new ResponseEntity<List<User>>(service.getUserList(), HttpStatus.OK);
	}

	@GetMapping("/user/id/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		return new ResponseEntity<User>(service.getUserById(id), HttpStatus.OK);
	}

	@GetMapping("/user/name/{name}")
	public ResponseEntity<User> getUserByName(@PathVariable String name) {
		return new ResponseEntity<User>(service.getUserByName(name), HttpStatus.OK);
	}

}
