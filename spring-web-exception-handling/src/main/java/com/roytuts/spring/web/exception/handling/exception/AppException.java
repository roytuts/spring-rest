package com.roytuts.spring.web.exception.handling.exception;

public class AppException extends Exception {

	private static final long serialVersionUID = 1L;

	private String code;

	public AppException(String message) {
		super(message);
		this.code = null;
	}

	public AppException(Throwable cause) {
		super(cause);
		this.code = null;
	}

	public AppException(String message, String code) {
		super(message);
		this.code = code;
	}

	public AppException(String message, Throwable cause) {
		super(message, cause);
		this.code = null;
	}

	public String getCode() {
		return code;
	}

}
