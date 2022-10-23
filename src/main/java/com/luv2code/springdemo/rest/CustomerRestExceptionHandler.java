package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice	// to setup global exception handler
public class CustomerRestExceptionHandler {

	// Add an exception handler for CustomerNotFoundException
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException ex) {
		
		// create CustomerErrorResponse
		CustomerErrorResponse response = new CustomerErrorResponse();
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setMessage(ex.getMessage());
		response.setTimestamp(System.currentTimeMillis());
		
		// return ResponseEntity
		
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	// Add another exception handler ... to catch any exception (catch all)
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception ex) {
		
		// create CustomerErrorResponse
		CustomerErrorResponse response = new CustomerErrorResponse();
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setMessage(ex.getMessage());
		response.setTimestamp(System.currentTimeMillis());
		
		// return ResponseEntity
		
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
