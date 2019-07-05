package com.jeejava.spring.web.exception.handling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeejava.spring.web.exception.handling.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee findByName(String name);

	Employee findByEmail(String email);

}
