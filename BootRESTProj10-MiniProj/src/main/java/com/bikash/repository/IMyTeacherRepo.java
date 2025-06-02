package com.bikash.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikash.entity.Teacher;

public interface IMyTeacherRepo extends JpaRepository<Teacher,Integer> {

}
