package com.roytuts.springrestserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.roytuts.springrestserver.model.Employee;
import com.roytuts.springrestserver.service.EmployeeService;

@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees() {
		return new ResponseEntity<List<Employee>>(employeeService.getEmployeeList(), HttpStatus.OK);
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
		return new ResponseEntity<Employee>(employeeService.getEmployee(), HttpStatus.OK);
	}

}
