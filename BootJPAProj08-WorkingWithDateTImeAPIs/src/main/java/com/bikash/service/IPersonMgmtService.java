package com.bikash.service;

import com.bikash.entity.PersonDetails;

public interface IPersonMgmtService {
	public String registerPerson(PersonDetails person);
	public String getPersonAge(int id);
	public int getPersonAgeByOracleQuery(int id);
	public int getPersonAgeByMySqlQuery(int id);
}
