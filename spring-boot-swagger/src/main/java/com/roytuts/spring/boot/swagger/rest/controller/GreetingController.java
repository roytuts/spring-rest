package com.roytuts.spring.boot.swagger.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
//@RequestMapping("/")
@Api(tags = "Message API", value = "Controller handles different messages")
public class GreetingController {

	@GetMapping("/hello")
	@ApiOperation(value = "Returns a String", notes = "Method to return a string message.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 404, message = "The resource not found") })
	public ResponseEntity<String> getMsg() {
		return new ResponseEntity<>("Hello, Welcome to Swagger", HttpStatus.OK);
	}

	@GetMapping("/hello/{name}")
	@ApiOperation(value = "Returns a String with name", notes = "Method to return a string message with name.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 404, message = "The resource not found") })
	public ResponseEntity<String> getMsg(@PathVariable String name) {
		return new ResponseEntity<>("Hello " + name, HttpStatus.OK);
	}

	@PostMapping("/hello")
	@ApiOperation(value = "Returns a String with name", notes = "Method to return a string message with name.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 404, message = "The resource not found") })
	public ResponseEntity<String> msg(@RequestBody String name) {
		return new ResponseEntity<>("Hello " + name, HttpStatus.OK);
	}

}
