package com.bikash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikash.entity.Artist;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class MyArtistServiceImpl implements IMyArtistService {

	@Autowired
	private EntityManager manager;
	
	/*CREATE OR REPLACE PROCEDURE ARTISTHEROPROC 
	(
	  ARTISTTYPE IN VARCHAR2 
	, DETAILS OUT SYS_REFCURSOR 
	) AS 
	BEGIN
	  open DETAILS for
	    select * from artist_info where ATYPE=ARTISTTYPE;
	END ARTISTHEROPROC;*/
			  
	@Override
	public List<Artist> getArtistByType(String aType) {
		// Step-1 Create Store Procedure Query object
		StoredProcedureQuery query=manager.createStoredProcedureQuery("ARTISTHEROPROC",Artist.class);
		
		//Step-2 Register query parameter
		query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
		query.registerStoredProcedureParameter(2,Object.class,ParameterMode.REF_CURSOR);
		
		//Step-3 Set query parameter values
		query.setParameter(1,aType);
		
		//Step-4 execute PL SQL procedure
		List<Artist> list=query.getResultList();
		return list;
	}
}
