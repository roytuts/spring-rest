package com.roytuts.springboot.rest.api.multivaluemap.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class App implements CommandLineRunner {

	@Autowired
	private RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args).close();
	}

	@Override
	public void run(String... args) throws Exception {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("Accept-Encoding", "compress;q=0.5");
		map.add("Accept-Encoding", "gzip;q=1.0");
		map.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);

		String response = restTemplate.postForObject("http://localhost:8080/multiValueMap", map, String.class);

		System.out.println("Response: " + response);
	}

}
