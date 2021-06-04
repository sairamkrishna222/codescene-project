package com.srk.moviecatalogue.exception;

import java.util.Date;

import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler  {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest requset) {

		DefaultErrorMessage errormsg = new DefaultErrorMessage(requset.getDescription(false), ex.getMessage(),
				new Date());

		return new ResponseEntity<>(errormsg, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(APIException.class)
	public ResponseEntity<?> handleAPIException(APIException ex, WebRequest requset) {

		DefaultErrorMessage errormsg = new DefaultErrorMessage(requset.getDescription(false), ex.getMessage(),
				new Date());

		return new ResponseEntity<>(errormsg, HttpStatus.NOT_FOUND);
	}
	
	  @ExceptionHandler(ValidationException.class) public ResponseEntity<?>
	  handleValidationException(ValidationException ex, WebRequest requset) {
	  
	  DefaultErrorMessage errormsg =new
	  DefaultErrorMessage(requset.getDescription(false),ex.getMessage(), new
	  Date()) ;
	  
	  return new ResponseEntity<>(errormsg, HttpStatus.BAD_REQUEST); }
	  
	 
    
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidExceptionOne(MethodArgumentNotValidException ex,
			WebRequest requset) {

		DefaultErrorMessage errormsg = new DefaultErrorMessage(requset.getDescription(false),
				ex.getBindingResult().getFieldError().getDefaultMessage(), new Date());

		return new ResponseEntity<>(errormsg, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleExceptionLater(Exception ex, WebRequest requset) {

		DefaultErrorMessage errormsg = new DefaultErrorMessage(requset.getDescription(false), ex.getMessage(),
				new Date());

		return new ResponseEntity<>(errormsg, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
