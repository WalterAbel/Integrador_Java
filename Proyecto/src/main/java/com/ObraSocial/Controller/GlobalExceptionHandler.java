package com.ObraSocial.Controller;

import java.util.Date;
import com.ObraSocial.Error.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.ObraSocial.Exceptions.RecetaNotFoundException;
import com.ObraSocial.Exceptions.ResourceNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Error> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		Error errorDetails = new Error();
		errorDetails.setDate(new Date());
		errorDetails.setMessage(ex.getMessage());
		errorDetails.setError("Not Found");
		errorDetails.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Error> handleGlobalException(Exception ex, WebRequest request) {
		Error errorDetails = new Error();
		errorDetails.setDate(new Date());
		errorDetails.setMessage(ex.getMessage());
		errorDetails.setError("Internal Server Error");
		errorDetails.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(RecetaNotFoundException.class)
	public ResponseEntity<Error> handleRecetaNotFoundException(RecetaNotFoundException ex, WebRequest request) {
		Error errorDetails = new Error();
		errorDetails.setDate(new Date());
		errorDetails.setMessage(ex.getMessage());
		errorDetails.setError("Not Found");
		errorDetails.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
}
