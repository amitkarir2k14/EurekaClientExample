package com.siemens.assignment.service.helper;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ServiceResponseHelper<T> {

	public ResponseEntity<T> getResponseEntity(T t, HttpHeaders headers, HttpStatus status) {
		return new ResponseEntity<T>(t, headers, status);
	}

	public ResponseEntity<T> getResponseEntity(T t, HttpStatus status) {
		return new ResponseEntity<T>(t, status);
	}
}