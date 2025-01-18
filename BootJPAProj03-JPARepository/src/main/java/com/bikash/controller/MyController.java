package com.bikash.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bikash.entity.Artist;
import com.bikash.service.IMyArtistService;

@Controller
public class MyController {
	
	@Autowired
	private IMyArtistService service;
	
	public String deleteAllArtistByIdInBatch(List<Integer> ids)
	{
		String msg=service.deleteArtistInBatch(ids);
		return msg;
	}
	public List<Artist> getArtistByGivenData(String name,Double fees)
	{
		return service.searchArtistByGivenData(name, fees);
	}
	
	public Optional<Artist> getArtistById(int id)
	{
		return service.loadById(id);
	}
	public Artist getArtistRefById(int id)
	{
		return service.loadArtistRefById(id);
	}
}
