package com.bikash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import com.bikash.entity.Artist;
import com.bikash.service.IArtistService;

@Controller
public class MyArtistController {
	
	@Autowired
	private IArtistService service;
	
	public Iterable<Artist> getAllArtistWithSorting(boolean ascOrder,String...props)
	{
		Iterable<Artist> list=service.getAllArtistBySorting(ascOrder,props);
		return list;
	}
	public Page<Artist> showEmployeeByPage(int pageNo,int pageSize)
	{
		Page<Artist> page=service.getEmployeeByPaging(pageNo, pageSize);
		return page;
	}
	public void getEmployeePageByPage(int pageSize,boolean isASC,String...prop)
	{
		service.getEmployeePageByPage(pageSize, isASC, prop);
	}
}
