package com.bikash.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikash.entity.Artist;

public interface MyArtistRepo extends JpaRepository<Artist,Integer> {
	
	public List<Artist> findByAnameEquals(String name);  //findBy,getBy,readBy three are same
	public List<Artist> readByAtypeIs(String type);     //Equals and Is both are same
	public List<Artist> getByAtypeIgnoreCase(String type); //Equals and Is is optional , if we wont declare anything it will automatically take as Is
	public Iterable<Artist> findByAnameStartingWith(String startChar);
	public Iterable<Artist> findByAnameEndingWith(String endChar);
	public Iterable<Artist> findByAnameContaining(String charac);
	public Iterable<Artist> findByAnameEndingWithOrderByAnameAsc(String startChar);
	
	public List<Artist> findByAnameLike(String chara);
	public List<Artist> findByFeesBetween(Double start,Double End);
	public List<Artist> findByAtypeIn(String...type);
	
	
	
}

