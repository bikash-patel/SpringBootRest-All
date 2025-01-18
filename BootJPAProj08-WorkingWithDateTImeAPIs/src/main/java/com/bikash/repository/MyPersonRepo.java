package com.bikash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bikash.entity.PersonDetails;

public interface MyPersonRepo extends JpaRepository<PersonDetails,Integer> {
	
	@Query(value = "select (sysdate-dob)/365.25 from Person_Details where p_id=:id",nativeQuery = true)
	//Above query is valid for Oracle only because sysdate is predefine function available in oracle
	public int getAgeByOracleQuery(int id);
	//Above query is valid for Oracle only because sysdate is predefine function available in oracle
	@Query(value="select TIMESTAMPDIFF(year,dob,curdate()) from Person_Details where p_id=:id",nativeQuery = true)
	public int getAgeByMySqlQuery(int id);
}
