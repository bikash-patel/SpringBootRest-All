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

	/*	CREATE OR REPLACE PROCEDURE PERSONDETAILSPROC1 
		(
		  STARTFEES IN NUMBER 
		, ENDFEES IN NUMBER 
		, DETAILS OUT SYS_REFCURSOR 
		) AS 
		BEGIN
		  open DETAILS for
		    select * from artist_info where fees>=STARTFEES and fees<=ENDFEES;
		END PERSONDETAILSPROC1;  */
	
	@Override
	public List<Artist> getArtistByRange(double start, double end) {
		//STEP-1 : Create StoredProcedureQuery object
		StoredProcedureQuery query=manager.createStoredProcedureQuery("PERSONDETAILSPROC1",Artist.class);

		//STEP-2 Register the param
		query.registerStoredProcedureParameter(1,Double.class,ParameterMode.IN);  //index,returntype,parameter mode
		query.registerStoredProcedureParameter(2,Double.class,ParameterMode.IN);
		query.registerStoredProcedureParameter(3,Object.class,ParameterMode.REF_CURSOR);
		
		//STEP-3 Register the param values
		query.setParameter(1,start);
		query.setParameter(2,end);
		
		//STEP-4 Call the PL SQL Procedure
		List<Artist> list=query.getResultList();
		return list;
	}

}
