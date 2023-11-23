package com.roytuts.spring.rest.file.download.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roytuts.spring.rest.file.download.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
