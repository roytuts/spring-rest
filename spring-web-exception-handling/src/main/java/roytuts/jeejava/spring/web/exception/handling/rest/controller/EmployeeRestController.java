package com.roytuts.spring.web.exception.handling.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.roytuts.spring.web.exception.handling.entity.Employee;
import com.roytuts.spring.web.exception.handling.exception.EmployeeNotFoundException;
import com.roytuts.spring.web.exception.handling.repository.EmployeeRepository;

@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees() {
		return new ResponseEntity<List<Employee>>(employeeRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping("/employee/id/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@GetMapping("/employee/name/{name}")
	public ResponseEntity<Employee> getEmployeeByName(@PathVariable String name) {
		Employee employee = employeeRepository.findByName(name);
		if (employee == null) {
			throw new EmployeeNotFoundException(name);
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@GetMapping("/employee/email/{email}")
	public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable String email) {
		Employee employee = employeeRepository.findByEmail(email);
		if (employee == null) {
			throw new EmployeeNotFoundException(email);
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

}
