package com.n26.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(value = InvalidEpochException.class)
	public ResponseEntity EpochExceptionHandler(){
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

}
