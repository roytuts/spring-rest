package com.roytuts.springrestretry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roytuts.springrestretry.model.Employee;
import com.roytuts.springrestretry.service.EmployeeService;

@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees() {
		List<Employee> employees = employeeService.getEmployeeList();
		//List<Employee> employees = employeeService.getEmployeeList2();

		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

}
