package com.service.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice
public class DetailsRestExecptionHandle {

	@ExceptionHandler 
	public ResponseEntity<DetailsErrorResponse> handleException(DetailsNotFoundException exception,WebRequest request){
		
		DetailsErrorResponse error = new DetailsErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(new Date());
		error.setDetails(request.getDescription(false));
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<DetailsErrorResponse> handleException(Exception exception,WebRequest request){
		
		DetailsErrorResponse error = new DetailsErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(new Date());
		error.setDetails(request.getDescription(false));
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
}
