package com.bikash.service;

import java.util.List;

import com.bikash.entity.Teacher;

public interface IMyTeacherManagementService{
	public String registerTeacher(Teacher teacher);
	public List<Teacher> getAllTeacher();
	public Teacher getTeacherById(int id);
	public String updateTeacher(Teacher teacher);
	public String updateTeacherSchool(int id,String school);
}
