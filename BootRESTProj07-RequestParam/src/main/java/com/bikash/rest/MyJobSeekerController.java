package com.bikash.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("farmer-api")
public class MyJobSeekerController {
	
	@GetMapping("/request1")
	public ResponseEntity<String> getRequest1(@RequestParam(required = false) int no,@RequestParam(name="name",required = false,defaultValue = "Bikash") String ename)
	{
		System.out.println(no+"---"+ename);
		return new ResponseEntity<String>(no+"---"+ename,HttpStatus.OK);
	}
}

