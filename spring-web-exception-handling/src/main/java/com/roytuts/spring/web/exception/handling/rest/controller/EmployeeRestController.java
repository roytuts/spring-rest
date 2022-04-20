package com.roytuts.spring.web.exception.handling.rest.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.roytuts.spring.web.exception.handling.entity.Employee;
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
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new Error("Employee not found for the given id " + id));

		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@GetMapping("/employee/name/{name}")
	public ResponseEntity<Employee> getEmployeeByName(@PathVariable String name) {
		Employee employee = employeeRepository.findByName(name);

		if (employee == null) {
			throw new Error("Employee not found for the given name " + name);
		}

		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@GetMapping("/employee/email/{email}")
	public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable String email) {
		Employee employee = employeeRepository.findByEmail(email);

		if (employee == null) {
			throw new Error("Employee not found for the given email " + email);
		}

		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@PostMapping("/employee/save")
	public ResponseEntity<Void> saveNewEmployee(@RequestBody Employee employee) {
		if (Objects.isNull(employee.getName()) || Objects.isNull(employee.getEmail())) {
			throw new IllegalArgumentException("Invalid request");
		}

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

}
