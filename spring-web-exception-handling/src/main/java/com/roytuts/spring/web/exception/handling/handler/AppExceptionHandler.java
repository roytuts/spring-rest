package com.roytuts.spring.web.exception.handling.handler;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;

import com.roytuts.spring.web.exception.handling.constants.AppConstants;
import com.roytuts.spring.web.exception.handling.exception.AppException;
import com.roytuts.spring.web.exception.handling.exception.DbException;
import com.roytuts.spring.web.exception.handling.wrapper.ExceptionWrapper;

@ControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(AppException.class)
	public ResponseEntity<ExceptionWrapper> appException(AppException exception) {
		if (!Objects.isNull(exception.getCode()) && AppConstants.SUCCESS.equalsIgnoreCase(exception.getCode())) {
			ExceptionWrapper exceptionWrapper = new ExceptionWrapper(HttpStatus.OK.toString(), exception.getMessage());

			return new ResponseEntity<ExceptionWrapper>(exceptionWrapper, HttpStatus.OK);
		}

		ExceptionWrapper exceptionWrapper = new ExceptionWrapper(HttpStatus.INTERNAL_SERVER_ERROR.toString(),
				exception.getMessage());

		return new ResponseEntity<ExceptionWrapper>(exceptionWrapper, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(DbException.class)
	public ResponseEntity<ExceptionWrapper> dbException(DbException exception) {
		if (!Objects.isNull(exception.getMessage())
				&& AppConstants.INCORRECT_RESULT_SIZE.equalsIgnoreCase(exception.getMessage())) {
			ExceptionWrapper exceptionWrapper = new ExceptionWrapper(HttpStatus.OK.toString(), exception.getMessage());

			return new ResponseEntity<ExceptionWrapper>(exceptionWrapper, HttpStatus.OK);
		}

		ExceptionWrapper exceptionWrapper = new ExceptionWrapper(HttpStatus.INTERNAL_SERVER_ERROR.toString(),
				exception.getMessage());

		return new ResponseEntity<ExceptionWrapper>(exceptionWrapper, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ExceptionWrapper> validationException(IllegalArgumentException exception) {
		ExceptionWrapper exceptionWrapper = new ExceptionWrapper(HttpStatus.BAD_REQUEST.toString(),
				exception.getMessage());

		return new ResponseEntity<ExceptionWrapper>(exceptionWrapper, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MultipartException.class)
	public ResponseEntity<ExceptionWrapper> multipartException(MultipartException exception) {
		ExceptionWrapper exceptionWrapper = new ExceptionWrapper(HttpStatus.INTERNAL_SERVER_ERROR.toString(),
				exception.getMessage());

		return new ResponseEntity<ExceptionWrapper>(exceptionWrapper, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Error.class)
	public ResponseEntity<ExceptionWrapper> otherError(Error error) {
		ExceptionWrapper exceptionWrapper = new ExceptionWrapper(HttpStatus.NOT_FOUND.toString(), error.getMessage());

		return new ResponseEntity<ExceptionWrapper>(exceptionWrapper, HttpStatus.NOT_FOUND);
	}

}
