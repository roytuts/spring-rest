package com.jeejava.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jeejava.service.GreetingService;

@RestController
@RequestMapping("/")
public class GreetingRestController {

	@Autowired
	private GreetingService greetingService;

	@RequestMapping(value = "greet/{name}", method = RequestMethod.GET)
	public ResponseEntity<String> getGreetingMsg(@PathVariable String name)
			throws InterruptedException, ExecutionException {
		String msg = greetingService.getGreetingMsg(name).get();
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

	@RequestMapping(value = "log", method = RequestMethod.POST)
	public ResponseEntity<Void> logMsg() throws InterruptedException, ExecutionException {
		greetingService.logMsg();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
