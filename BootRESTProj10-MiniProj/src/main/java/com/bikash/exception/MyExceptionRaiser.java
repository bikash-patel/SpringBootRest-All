package com.bikash.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bikash.model.ExceptionDetails;

//@ControllerAdvice

//Below is equal to @RestControllerAdvice= @ControllerAdvice + @ResponseBody
@RestControllerAdvice
//If any exception raise in rest , it automatically redorect to Advice class
public class MyExceptionRaiser {
	
	@ExceptionHandler(exception = TeacherNotFoundException.class)
	public ResponseEntity<ExceptionDetails> handleTeacherNotFound(TeacherNotFoundException e)
	{
		ExceptionDetails excdet=new ExceptionDetails(LocalDate.now(),e.getMessage(), "204 Teacher Not Found");
		return new ResponseEntity<ExceptionDetails>(excdet,HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(exception = Exception.class)
	public ResponseEntity<ExceptionDetails> allExceptionHandler(Exception e)
	{
		ExceptionDetails excdet=new ExceptionDetails(LocalDate.now(),e.getMessage(), "Global Exception Occured");
		return new ResponseEntity<ExceptionDetails>(excdet,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
