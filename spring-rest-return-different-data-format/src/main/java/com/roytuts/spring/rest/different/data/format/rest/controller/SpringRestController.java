package com.roytuts.spring.rest.different.data.format.rest.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roytuts.spring.rest.different.data.format.model.Employee;

@RestController
public class SpringRestController {

    @GetMapping(value = "/entityEmployees", produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE })
    public ResponseEntity<List<Employee>> getEmployeesEntity() {
        return new ResponseEntity<List<Employee>>(employees(), HttpStatus.OK);
    }

    @GetMapping(value = "/employees", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,
            MediaType.TEXT_XML_VALUE })
    public List<Employee> getEmployees() {
        return employees();
    }

    @GetMapping(value = "/entityEmployee", produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE })
    public ResponseEntity<Employee> getEmployeeEntity() {
        return new ResponseEntity<Employee>(new Employee("John", "Developer"), HttpStatus.OK);
    }

    @GetMapping(value = "/employee", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,
            MediaType.TEXT_XML_VALUE })
    public Employee getEmployee() {
        return new Employee("John", "Developer");
    }

    private List<Employee> employees() {
        List<Employee> employees = Arrays.asList(new Employee("John", "Developer"),
                new Employee("Michel", "Sr Developer"), new Employee("Harris", "Developer"),
                new Employee("Kamla", "Sr Developer"), new Employee("Jerome", "Manager"));

        return employees;
    }
}
