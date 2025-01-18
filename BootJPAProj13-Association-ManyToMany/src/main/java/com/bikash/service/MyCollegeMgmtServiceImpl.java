package com.bikash.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikash.entity.Faculty;
import com.bikash.entity.Student;
import com.bikash.repository.MyFacultyRepo;
import com.bikash.repository.MyStudentRepo;

@Service
public class MyCollegeMgmtServiceImpl implements IMyCollegeMgmtService {

	@Autowired
	private MyFacultyRepo facultyRepo;
	
	@Autowired
	private MyStudentRepo studentRepo;
	
	@Override
	public void saveDetailFromParentToChild() {
		//Create Parent object
		Faculty fac1=new Faculty("Sanjukta","Bhukta");
		Faculty fac2=new Faculty("Manish","Burla");
		
		//Create Associated child object
		Student s1=new Student("Bikash","Khairpali");
		Student s2=new Student("Premchand","Chikhili");
		Student s3=new Student("Manas","Bhatli");
		
		//Set Child to parent
		fac1.getStudentInfo().add(s1);   //Faculty 1 teaches all 3 student
		fac1.getStudentInfo().add(s2);
		fac1.getStudentInfo().add(s3);
		
		fac2.getStudentInfo().add(s1);  //Faculty 2 teaches only student 1 and 2
		fac2.getStudentInfo().add(s2);
		
		//Set Parent to Child
		s1.getFacultyInfo().add(fac1);  //Stud 1 study from both Faculty
		s1.getFacultyInfo().add(fac2);
		
		s2.getFacultyInfo().add(fac1);  //Stud 2 study from both Faculty
		s2.getFacultyInfo().add(fac2);
		
		s3.getFacultyInfo().add(fac1);  //Stud 3 study from 1st Faculty only
		
		facultyRepo.save(fac1);
		facultyRepo.save(fac2);
		
		System.out.println("Details saved of both parent and child");
		
	}
	@Override
	public void saveDetailFromChildToParent() {
				//Create Parent object
				Faculty fac1=new Faculty("Ganesh","Kamgaon");
				Faculty fac2=new Faculty("Rout","Sambalpur");
				
				//Create Associated child object
				Student s1=new Student("Amit","Bhukta");
				Student s2=new Student("Bhisma","Chikhili");
				Student s3=new Student("Abhishek","Satidarha");
				
				//Set Child to parent
				fac1.getStudentInfo().add(s1);   //Faculty 1 teaches 1st and 2nd student
				fac1.getStudentInfo().add(s2);
				
				fac2.getStudentInfo().add(s1);  //Faculty 2 teaches 1st and 3rd student
				fac2.getStudentInfo().add(s3);
				
				//Set Parent to Child
				s1.getFacultyInfo().add(fac1);  //Stud 1 study from both Faculty
				s1.getFacultyInfo().add(fac2);
				
				s2.getFacultyInfo().add(fac1);  //Stud 2 study from only 1st Faculty
				
				s3.getFacultyInfo().add(fac2);  //Stud 3 study from 2nd Faculty only
				
				studentRepo.save(s1);
				studentRepo.save(s2);
				studentRepo.save(s3);
				
				System.out.println("Details saved of both from child to parent");
	}
	@Override
	public void loadDetailsFromParentToChild() {
		List<Faculty> list=facultyRepo.findAll();
		list.forEach(fac->{
					System.out.println(fac);
					Set<Student> set=fac.getStudentInfo();
					set.forEach(std-> {
					System.out.println(std);});
		});
	}

}
