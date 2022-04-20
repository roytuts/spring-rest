package com.roytuts.spring.web.exception.handling.exception;

public class DbException extends Exception {

	private static final long serialVersionUID = 1L;

	public DbException(String message) {
		super(message);
	}

	public DbException(String message, Throwable cause) {
		super(message, cause);
	}

}
