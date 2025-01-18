package com.bikash.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikash.entity.Books;

public interface MyBooksRepo extends JpaRepository<Books,Integer> {

}
