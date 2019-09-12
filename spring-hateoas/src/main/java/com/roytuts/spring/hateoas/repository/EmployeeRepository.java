package com.roytuts.spring.hateoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roytuts.spring.hateoas.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee findById(int id);

	Employee findByName(String name);

	Employee findByEmail(String email);

}
