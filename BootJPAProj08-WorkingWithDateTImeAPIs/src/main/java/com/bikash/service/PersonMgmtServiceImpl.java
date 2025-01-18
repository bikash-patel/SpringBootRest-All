package com.bikash.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikash.entity.PersonDetails;
import com.bikash.repository.MyPersonRepo;

@Service
public class PersonMgmtServiceImpl implements IPersonMgmtService {

	@Autowired
	private MyPersonRepo personRepo;
	
	@Override
	public String registerPerson(PersonDetails person) {
		int id=personRepo.save(person).getPId();
		return "Person Details saved with id "+id;
	}

	@Override
	public String getPersonAge(int id) {
		PersonDetails person=personRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Person Id not found"));
		Period p=Period.between(person.getDob(),LocalDate.now());
		String msg="You age is "+p.getYears()+" years "+p.getMonths()+" month "+p.getDays()+" days";
		return msg;
	}
	@Override
	public int getPersonAgeByOracleQuery(int id) {
		return personRepo.getAgeByOracleQuery(id);
	}
	@Override
	public int getPersonAgeByMySqlQuery(int id) {
		return personRepo.getAgeByMySqlQuery(id);
	}
}
