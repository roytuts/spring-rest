package com.roytuts.spring.resttemplate.proxy.timeout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestApiController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/fetch")
	public ResponseEntity<Object> fetchSomething() {
		Object response = restTemplate.getForObject("url of the REST API", Object.class);

		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<Object> createSomething(@RequestBody Object obj) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Content-Type", "application/json");
		httpHeaders.set("Authorization", "Bearer token value");

		Object request = new Object();

		HttpEntity<Object> httpEntity = new HttpEntity<Object>(request, httpHeaders);

		Object response = restTemplate.postForObject("url of the REST API", httpEntity, Object.class);

		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

}
