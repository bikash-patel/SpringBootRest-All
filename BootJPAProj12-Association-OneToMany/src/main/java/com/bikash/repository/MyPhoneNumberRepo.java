package com.bikash.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikash.entity.PhoneNumber;

public interface MyPhoneNumberRepo extends JpaRepository<PhoneNumber,Integer> {

}
