package com.roytuts.spring.rest.download.file.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roytuts.spring.rest.download.file.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
