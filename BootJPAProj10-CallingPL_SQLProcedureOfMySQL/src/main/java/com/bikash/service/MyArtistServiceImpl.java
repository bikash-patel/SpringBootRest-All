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
	
	/*CREATE DEFINER=`root`@`localhost` PROCEDURE `P_GET_ARTISTFEERANGE`(in start double,in end double)
			BEGIN
				select * from artist_info where fees>=start and fees<=end;
			END*/
			  
	@Override
	public List<Artist> getArtistByRange(double start,double end) {
		// Step-1 Create Store Procedure Query object
		StoredProcedureQuery query=manager.createStoredProcedureQuery("P_GET_ARTISTFEERANGE",Artist.class);
		
		//Step-2 Register PL SQL Procedure Parameter
		query.registerStoredProcedureParameter(1,Double.class,ParameterMode.IN);
		query.registerStoredProcedureParameter(2,Double.class,ParameterMode.IN);
		
		//Step-3 Set Value for store procedure query parameter
		query.setParameter(1,start);
		query.setParameter(2,end);
		
		//Step-4 Execute PL SQL parameter
		List<Artist> list=query.getResultList();
		return list; 
	}
}
