package com.bikash.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikash.entity.Library;

public interface MyLibraryRepo extends JpaRepository<Library,Integer> {

}
