package com.bikash.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikash.entity.Faculty;

public interface MyFacultyRepo extends JpaRepository<Faculty,Integer> {

}
