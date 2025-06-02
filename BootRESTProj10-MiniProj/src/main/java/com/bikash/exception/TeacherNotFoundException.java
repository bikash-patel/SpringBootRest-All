package com.bikash.exception;

public class TeacherNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TeacherNotFoundException()
	{
		super();
	}
	public TeacherNotFoundException(String exception)
	{
		super(exception);
	}
}
