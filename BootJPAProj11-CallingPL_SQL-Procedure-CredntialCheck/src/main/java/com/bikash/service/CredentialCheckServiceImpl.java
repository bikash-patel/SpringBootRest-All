package com.bikash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class CredentialCheckServiceImpl implements ICredentialCheckService {

	@Autowired
	private EntityManager manager;
	
	/*CREATE DEFINER=`root`@`localhost` PROCEDURE `P_GET_CREDENTIALCHECK`(in uname varchar(20),in passwd varchar(20),out result varchar(40))
			BEGIN
			 declare cnt int;
			 select count(*) into cnt from authentication where username=uname and password=passwd;
			 if(cnt<>0) then
			    set result="Valid Credential";
			else
			    set result="Invalid Credential";
			end if;
			END*/
	
	@Override
	public String login(String userName, String password) {
		//Create Store Procedure Query object
		StoredProcedureQuery query=manager.createStoredProcedureQuery("P_GET_CREDENTIALCHECK");
		//Register Store Procedure
		query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
		query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
		query.registerStoredProcedureParameter(3,String.class,ParameterMode.OUT);
		
		//Set value for store procedure
		query.setParameter(1,userName);
		query.setParameter(2,password);
		
		//Call the query parameter
		String result=(String) query.getOutputParameterValue(3);
		return result;
	}

}
