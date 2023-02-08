package com.axis.productservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalProductHandler {
	
	@ExceptionHandler(value = ProductNotFoundException.class)
	 public ResponseEntity<String>productNotFoundExceptionHandler(ProductNotFoundException ex) {
		 return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	 }

}

