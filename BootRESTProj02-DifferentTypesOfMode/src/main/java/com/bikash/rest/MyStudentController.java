package com.bikash.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student-api")
public class MyStudentController {
	
	@GetMapping("/report")
	public ResponseEntity<String> getReport()
	{
		return new ResponseEntity<String>("Student Result Processing",HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> getRegister()
	{
		return new ResponseEntity<String>("Student Register",HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> getUpdate()
	{
		return new ResponseEntity<String>("Student Result Updating(Full Update)",HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> getDelete()
	{
		return new ResponseEntity<String>("Student Result Deleting",HttpStatus.OK);
	}
	
	@PatchMapping("/edit")
	public ResponseEntity<String> getEdit()
	{
		return new ResponseEntity<String>("Student Result Editing (Partial Editing)",HttpStatus.OK);
	}
}
