package com.bikash.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikash.entity.Teacher;
import com.bikash.exception.TeacherNotFoundException;
import com.bikash.repository.IMyTeacherRepo;

@Service
public class MyTeacherManagementRepoImpl implements IMyTeacherManagementService {

	@Autowired
	private IMyTeacherRepo repo;
	
	@Override
	public String registerTeacher(Teacher teacher) {
		int id=repo.save(teacher).getTid();
		return "Teacher saved with id "+id;
	}

	@Override
	public List<Teacher> getAllTeacher() {
		List<Teacher> teacherList=repo.findAll().stream().sorted((t1,t2)->t1.toString().compareTo(t2.toString())).toList();
		return teacherList;
	}

	/*@Override
	public Teacher getTeacherById(int id) {
		try {
			return repo.findById(id).orElseThrow(()->new IllegalAccessException("Id not found"));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}
	}*/
	
	@Override
	public Teacher getTeacherById(int id) {
			return repo.findById(id).orElseThrow(()->new TeacherNotFoundException("Teacher id not found"));
	}
	
	@Override
	public String updateTeacher(Teacher teacher) {
		int id=teacher.getTid();
		Optional<Teacher> opt=repo.findById(id);
		if(opt.isPresent())
			repo.save(teacher);
		else
			return "Teacher having id "+id+" not found";
		return "Teacher having id "+id+" updated";
	}
	
	@Override
	public String updateTeacherSchool(int id, String school) {
		Optional<Teacher> opt=repo.findById(id);
		if(opt.isPresent())
		{
			Teacher teacher=opt.get();
			teacher.setSchool(school);
			repo.save(teacher);
		}
		else
		{
			return "Teacher having id "+id+" not found";
		}
		return id+" Teacher's school details updated";
	}

}
