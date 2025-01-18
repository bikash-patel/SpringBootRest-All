package com.bikash.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bikash.entity.Artist;

import jakarta.transaction.Transactional;

public interface MyArtistRepo extends JpaRepository<Artist,Integer> {
	
	//@Query("from Artist")
	//@Query("from Artist art") //Here art is alias name (as is optional )
	@Query("select art from com.bikash.entity.Artist as art")
	public List<Artist> getAllArtist();
	
	//@Query("from Artist where fees>=?1 and fees<=?2")  //always should start from 1 not from 0 or any other digit
	@Query("from Artist where fees>=:start and fees<=:end")
	public List<Artist> getAllArtistByRange(@Param("start") double min,@Param("end")double max); 
	 //if method parameter name and named parameter parameter name are 
	//different then we need to place  @param
	
	@Query("from Artist where fees>=:start and fees<=:end")
	public List<Artist> fetchAllArtistByRange(double start,double end);
	
	@Query("from Artist where atype in (:desg1,:desg2,:desg3)") //Entity Query
	public List<Artist> getArtistByType(String desg1,String desg2,String desg3);
	
	@Query("select aname,fees from Artist where atype in (:desg1,:desg2,:desg3)") //Scaler Query getting specific multiple col value
	public List<Object[]> fetchArtistByType(String desg1,String desg2,String desg3);
	
	@Query("select aname from Artist where aname like :name") //Scaler Query getting specific single col value
	public List<String> loadArtistByType(String name);
	
	@Query("from Artist where aname=:name")
	public Artist getArtistByName(String name); //single record entity(getting all record) query
	
	@Query("select aname,fees from Artist where aname=:name")
	public Object loadArtistByName(String name); //single record scalar query giving multiple col value
	
	@Query("select fees from Artist where aname=:name")
	public Double fetchArtistByName(String name); //single record scalar query giving single col value
	
	@Query("select count(distinct aname) from Artist")
	public Integer fetchArtistCount(); //Aggregation query
	
	@Query("select max(fees) from Artist")
	public Integer fetchMaxFeesFromArtist(); //Aggregation query
	
	@Query("select min(fees) from Artist")
	public Integer fetchMinFeesFromArtist(); //Aggregation query
	
	@Query("select sum(fees) from Artist")
	public Integer fetchTotalFeesFromArtist(); //Aggregation query
	
	//==========================================Non-Select Query=======================================
	
	
		@Transactional
		@Modifying
		@Query("update Artist set fees=fees+(fees*:percetage/100.0) where atype=:type")
		public int updateArtistSalary(String type,double percetage);
	
	@Transactional
	@Modifying
	@Query("delete Artist where fees>=:start and fees<=:end")
	public int deleteArtistBySalaryRange(double start,double end);
	
	
	
	//==========================================Native SQL Query=======================================
	
	
	@Query(value="SELECT SYSDATE FROM DUAL",nativeQuery = true)  //This is Oracle native query (not for sql)
	public LocalDateTime getCurrentDateTime();
	
	
	
}

