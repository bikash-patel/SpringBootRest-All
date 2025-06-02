package com.bikash.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikash.entity.Teacher;
import com.bikash.service.IMyTeacherManagementService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Teacher Management API",description = "Develope to perform CURD Operation")
@RequestMapping("/teacher-api")
public class MyTeacherController {
	
	@Autowired
	private IMyTeacherManagementService service;
	
	@Operation(summary = "To Save Teacher details",description = "Method is for insert data")
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Teacher teacher)
	{
		String msg=service.registerTeacher(teacher);
		System.out.println(teacher);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		
	}
	
	@Operation(summary = "To retrive Teacher details",description = "Method is for search all data")
	@GetMapping("/retrive")
	public ResponseEntity<List<Teacher>> getData()  //If return type is not fixed then we give ?
	{
			List<Teacher> list=service.getAllTeacher();
			return new ResponseEntity<List<Teacher>>(list,HttpStatus.OK);
	}
	
	@Operation(summary = "To retrive Teacher details",description = "Method is for search data based on provided id")
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Teacher> getById(@PathVariable int id)
	{
			Teacher teacher=service.getTeacherById(id);
			return new ResponseEntity<Teacher>(teacher,HttpStatus.OK);
	}
	
	@Operation(summary = "To updated Teacher details",description = "Method is for updated entire data")
	@PutMapping("/update") //Put mode request for full updation 
	public ResponseEntity<String> updateTeacher(@RequestBody Teacher teacher)
	{
			String msg=service.updateTeacher(teacher);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@Operation(summary = "To updated Teacher details",description = "Method is for updated school data")
	@PatchMapping("/update/{id}/{school}") //Patch mode request for partial updation 
	public ResponseEntity<String> updateTeacher(@PathVariable Integer id,@PathVariable String school)
	{
			String msg=service.updateTeacherSchool(id, school);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
}
