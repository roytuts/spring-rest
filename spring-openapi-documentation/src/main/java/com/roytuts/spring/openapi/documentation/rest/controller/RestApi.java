package com.roytuts.spring.openapi.documentation.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class RestApi {

	@Operation(summary = "Returns a response as Hello World!", description = "This GET operation returns a response as Hello World!")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "SUCCESS", content = @Content(schema = @Schema(type = "string"))),
			@ApiResponse(responseCode = "500", description = "FAILURE", content = @Content(schema = @Schema(implementation = RuntimeException.class))) })
	@GetMapping("/")
	public ResponseEntity<String> greet() {
		return new ResponseEntity<String>("Hello World!", HttpStatus.OK);
	}

	@Operation(summary = "Returns a response as Hello with a name", description = "This POST operation returns a response as Hello with a given name")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "SUCCESS", content = @Content(schema = @Schema(type = "string"))),
			@ApiResponse(responseCode = "500", description = "FAILURE", content = @Content(schema = @Schema(implementation = RuntimeException.class))) })
	@PostMapping("/greet")
	public ResponseEntity<String> greet(@RequestBody String name) {
		return new ResponseEntity<String>("Hello, " + name, HttpStatus.OK);
	}

}
