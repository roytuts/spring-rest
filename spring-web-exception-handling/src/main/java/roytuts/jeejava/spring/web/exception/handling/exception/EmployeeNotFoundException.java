package com.roytuts.spring.web.exception.handling.exception;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException(Integer id) {
		super("Could not find employee with id " + id);
	}

	public EmployeeNotFoundException(String str) {
		super("Could not find employee with name or email " + str);
	}

}
