package com.bikash.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bikash.entity.Artist;
import com.bikash.service.IArtistService;
@Controller
public class ArtistController {
	
	@Autowired
	private IArtistService service;
	
	public String insertArtis(Artist artist)
	{
		String msg=service.registerArtist(artist);
		return msg;
	}
	public boolean isIdAvailable(Integer id)
	{
		return service.checkIdAvailable(id);
	}
	public long totolArtist()
	{
		return service.totalArtist();
	}
	public String registerArtistBatch(List<Artist> list)
	{
		String msg=service.registerArtistBatch(list);
		return msg;
	}
	public Iterable<Artist> getAllArtist()
	{
		Iterable<Artist> itr=service.findAllArtist();
		return itr;
	}
	public Iterable<Artist> getAllArtistByIds(Iterable<Integer> ids)
	{
		Iterable<Artist> iterable=service.findAllArtistByIds(ids);
		return iterable;
	}
	public Optional<Artist> getArtistById(int id)
	{
		Optional<Artist> optitonal=service.getArtistById(id);
		return optitonal;
	}
	public Artist extracrArtistById(int id)
	{
		Artist artist=service.extracrArtistById(id);
		return artist;
	}
	public String registerOrUpdateArtist(Artist artist)
	{
		String msg=service.registerOrUpdateArtist(artist);
		return msg;
	}
	public String hikeArtistFeeByPercentage(int id,double percentage)
	{
		String msg=service.hikeArtistFee(id, percentage);
		return msg;
	}
	public String allArtistDelete()
	{
		String msg=service.deleteAllArtist();
		return msg;
	}
	public String deleteAllArtistById(Iterable<Integer> ids)
	{
		return service.deleteAllArtistById(ids);
	}
}
