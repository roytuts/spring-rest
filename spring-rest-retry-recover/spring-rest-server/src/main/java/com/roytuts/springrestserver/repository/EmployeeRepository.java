package com.roytuts.springrestserver.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.roytuts.springrestserver.model.Employee;

@Repository
public class EmployeeRepository {

	public List<Employee> getEmployeeList() {
		List<Employee> employees = Arrays.asList(new Employee(1, "Smith John", 1000000.00),
				new Employee(2, "John Carle", 1200000.00), new Employee(3, "Micheal Vaun", 1020000.00),
				new Employee(4, "Jerome K Jerome", 1250000.00));

		return employees;
	}

	public Employee getEmployeeById() {
		return new Employee(1, "Smith John", 1000000.00);
	}

}
