package com.bikash.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome-api")
public class MyController {
	
	@GetMapping("/welcome")
	public ResponseEntity<String> getMessage()
	{
		return new ResponseEntity<String>("Welcome to Spring Boot Rest",HttpStatus.OK);
	}
}
