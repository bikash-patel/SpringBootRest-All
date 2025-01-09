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
	
	
	/*Here if we pass request with url /request1/101/name then all the method request is 
	 matching , in this case request with more static path will get 1st priority
	 */
	
	@GetMapping("/request1/{no}/{name}")
	public ResponseEntity<String> getPrinter1(@PathVariable(name = "no",required = false) Integer cno,@PathVariable(required = false) String name)
	{
		System.out.println("Request section 1");
		return new ResponseEntity<String>("Request section 1",HttpStatus.OK);
	}
	
	@GetMapping("/request1/{no}/name")
	public ResponseEntity<String> getPrinter2(@PathVariable(name = "no",required = false) Integer cno,@PathVariable(required = false) String name)
	{
		System.out.println("Request section 2");
		return new ResponseEntity<String>("Request section 2",HttpStatus.OK);
	}
	
	@GetMapping("/request1/101/{name}")
	public ResponseEntity<String> getPrinter3(@PathVariable(name = "no",required = false) Integer cno,@PathVariable(required = false) String name)
	{
		System.out.println("Request section 3");
		return new ResponseEntity<String>("Request section 3",HttpStatus.OK);
	}
	
	@GetMapping("/request1/101/name")
	public ResponseEntity<String> getPrinter4(@PathVariable(name = "no",required = false) Integer cno,@PathVariable(required = false) String name)
	{
		System.out.println("Request section 4");
		return new ResponseEntity<String>("Request section 4",HttpStatus.OK);
	}
}
