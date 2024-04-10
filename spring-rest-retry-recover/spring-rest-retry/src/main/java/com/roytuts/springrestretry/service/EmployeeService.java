package com.roytuts.springrestretry.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.roytuts.springrestretry.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private RetryTemplate retryTemplate;

	//Default retry policy
	//@Retryable(retryFor = Exception.class)
	
	//Simple retry policy
	//@Retryable(retryFor = Exception.class, maxAttempts = 4, backoff = @Backoff(delay = 1000))
	
	//Exponential Backoff Policy
	//@Retryable(retryFor = Exception.class, maxAttempts = 5, backoff = @Backoff(delay = 1000, multiplier = 2, maxDelay = 10000))
	
	//Random Backoff retry policy
	@Retryable(retryFor = Exception.class, maxAttempts = 4, backoff = @Backoff(delay = 1000, maxDelay = 10000, random = true))
	public List<Employee> getEmployeeList() {
		System.out.println("Try ");
		
		List<Employee> employees = restTemplate.exchange("http://localhost:9000/employees", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Employee>>() {
				}).getBody();
		
		return employees;
	}
	
	public List<Employee> getEmployeeList2() {
		retryTemplate.execute((RetryCallback<List<Employee>, RestClientException>) context -> {
			System.out.println("Try ");

			List<Employee> employees = restTemplate.exchange("http://localhost:9000/employees", HttpMethod.GET, null,
					new ParameterizedTypeReference<List<Employee>>() {
					}).getBody();

			return employees;
		});

		return null;
	}

	@Recover
	public List<Employee> employees(Exception e) {
		List<Employee> employees = Arrays.asList(new Employee(1, "Smith John", 1000000.00),
				new Employee(2, "John Carle", 1200000.00));

		return employees;
	}
}
