package com.bikash.service;

import java.util.List;
import java.util.Optional;

import com.bikash.entity.Artist;

public interface IMyArtistService {
	public String deleteArtistInBatch(List<Integer> ids);
	
	public List<Artist> searchArtistByGivenData(String name,Double fees);
	
	public Optional<Artist> loadById(int id);
	
	public Artist loadArtistRefById(int id);
}
