package com.roytuts.springboot.rest.api.multivaluedmap.rest.controller;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRestController {

	@PostMapping("/multiValueMap")
	public ResponseEntity<String> multiValueMap(@RequestBody MultiValueMap<String, String> multiValueMap) {
		String encoding = multiValueMap.get("Accept-Encoding").stream().map(String::toString)
				.collect(Collectors.joining(","));

		String contentType = multiValueMap.get("Content-Type").get(0);

		return new ResponseEntity<String>(encoding + "," + contentType, HttpStatus.OK);
	}

}
