package com.bikash.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("path-var-api")
public class MyController {
	
	@GetMapping("/request1") //If we pass extra path in string url we wont get error
	public ResponseEntity<String> getPrinter1(@RequestParam("no") int cno,@RequestParam(required = false) String name)
	{
		System.out.println(cno+"..."+name);
		return new ResponseEntity<String>(cno+"..."+name,HttpStatus.OK);
	}
	
	@GetMapping("/request2/{no}/{name}") //If we pass extra path in string url we will get error
	public ResponseEntity<String> getPrinter2(@PathVariable("no") int cno,@PathVariable String name)
	{
		System.out.println(cno+"..."+name);
		return new ResponseEntity<String>(cno+"..."+name,HttpStatus.OK);
	}
	
	@GetMapping("/request3/{no}/{name}") //If we won't pass value for name in  string url then we will get error
	public ResponseEntity<String> getPrinter3(@PathVariable("no") int cno,@PathVariable(required = false) String name)
	{
		System.out.println(cno+"..."+name);
		return new ResponseEntity<String>(cno+"..."+name,HttpStatus.OK);
	}
	
	@GetMapping({"/request4/{no}/{name}","/request4/{no}","/request4"}) //If we won't pass value for name in  string url then we will get error
	public ResponseEntity<String> getPrinter4(@PathVariable(name = "no",required = false) Integer cno,@PathVariable(required = false) String name)
	{
		System.out.println(cno+"..."+name);
		return new ResponseEntity<String>(cno+"..."+name,HttpStatus.OK);
	}
}
