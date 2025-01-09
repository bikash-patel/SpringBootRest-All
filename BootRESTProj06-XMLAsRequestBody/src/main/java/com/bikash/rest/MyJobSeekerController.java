package com.bikash.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikash.model.Farmer;

@RestController
@RequestMapping("farmer-api")
public class MyJobSeekerController {
	
	@PostMapping("/report1")
	public ResponseEntity<String> getReport1(@RequestBody Farmer frmr)
	{
		return new ResponseEntity<String>(frmr.toString(),HttpStatus.OK);
	}
	
	@PostMapping("/report2")
	public ResponseEntity<String> getReport2(@RequestBody List<Farmer> frmrList)
	{
		return new ResponseEntity<String>(frmrList.toString(),HttpStatus.OK);
	}
	
	@PostMapping("/report3")
	public String getReport3(@RequestBody Farmer frmr)
	{
		return frmr.toString();
	}
}

