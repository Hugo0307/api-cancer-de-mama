package com.api.devweek.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.api.devweek.exception.ElementNotFoundException;

@RestControllerAdvice
public class ControllerAdviceException {
	
	@ExceptionHandler(ElementNotFoundException.class)
	public ResponseEntity<Object> lidarComNotFoundException(ElementNotFoundException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

}
