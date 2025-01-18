package com.bikash.service;

import org.springframework.data.domain.Page;

import com.bikash.entity.Artist;

public interface IArtistService {
	
	public Iterable<Artist> getAllArtistBySorting(boolean ascOrder,String...props);
	public Page<Artist> getEmployeeByPaging(int pageNo,int pageSize);
	public void getEmployeePageByPage(int pageSize,boolean isASC,String...props);
}
