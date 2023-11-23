package com.roytuts.spring.rest.file.download.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.roytuts.spring.rest.file.download.entity.Employee;
import com.roytuts.spring.rest.file.download.repository.EmployeeRepository;

import jakarta.annotation.Resource;

@Service
public class EmployeeService {

	@Resource
	private EmployeeRepository employeeRepository;

	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

}
