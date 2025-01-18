package com.bikash.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikash.entity.Student;

public interface MyStudentRepo extends JpaRepository<Student,Integer> {

}
