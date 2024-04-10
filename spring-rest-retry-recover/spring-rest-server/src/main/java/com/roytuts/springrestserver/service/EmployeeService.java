package com.roytuts.springrestserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roytuts.springrestserver.model.Employee;
import com.roytuts.springrestserver.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getEmployeeList() {
		return employeeRepository.getEmployeeList();
	}

	public Employee getEmployee() {
		return employeeRepository.getEmployeeById();
	}

}
