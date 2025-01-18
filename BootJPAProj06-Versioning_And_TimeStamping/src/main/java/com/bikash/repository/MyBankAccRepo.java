package com.bikash.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikash.entity.BankAccount;

public interface MyBankAccRepo extends JpaRepository<BankAccount,Long> {
	
}
