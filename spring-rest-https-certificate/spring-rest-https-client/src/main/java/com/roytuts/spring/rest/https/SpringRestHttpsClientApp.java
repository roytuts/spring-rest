package com.roytuts.spring.rest.https;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.roytuts.spring.rest.https.client.TempConverterRestClient;

@SpringBootApplication
public class SpringRestHttpsClientApp implements CommandLineRunner {

	@Autowired
	private TempConverterRestClient tempConverterRestClient;

	public static void main(String[] args) {
		SpringApplication.run(SpringRestHttpsClientApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		tempConverterRestClient.temperature();
	}

}
