package com.bikash.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bikash.entity.Customer;

public interface MyCustomerRepo extends JpaRepository<Customer,Integer> {
	
	//@Query("select c.cId,c.cName,c.cAddress,ph.regNo,ph.mblNo,ph.provider,ph.numberType from Customer c inner join c.numberInfo ph")
	//@Query("select c.cId,c.cName,c.cAddress,ph.regNo,ph.mblNo,ph.provider,ph.numberType from Customer c left join c.numberInfo ph")
	//@Query("select c.cId,c.cName,c.cAddress,ph.regNo,ph.mblNo,ph.provider,ph.numberType from Customer c right join c.numberInfo ph")
	@Query("select c.cId,c.cName,c.cAddress,ph.regNo,ph.mblNo,ph.provider,ph.numberType from Customer c outer join c.numberInfo ph")
	public List<Object[]> loadDataUsingJoin();
}
