package com.roytuts.spring.async.rest.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roytuts.spring.async.service.GreetingService;

@RestController
public class GreetingRestController {

	@Autowired
	private GreetingService greetingService;

	@GetMapping("greet/{name}")
	public ResponseEntity<String> getGreetingMsg(@PathVariable String name)
			throws InterruptedException, ExecutionException {

		String msg = greetingService.getGreetingMsg(name).get();

		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

	@PostMapping("log")
	public ResponseEntity<Void> logMsg() throws InterruptedException, ExecutionException {

		greetingService.logMsg();

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
