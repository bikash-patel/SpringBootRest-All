package com.bikash.service;

import java.util.List;
import java.util.Optional;

import com.bikash.entity.Artist;

public interface IArtistService {
	
	public String registerArtist(Artist artist);
	public boolean checkIdAvailable(Integer id);
	public Long totalArtist();
	public String registerArtistBatch(List<Artist> list);
	public Iterable<Artist> findAllArtist();
	public Iterable<Artist> findAllArtistByIds(Iterable<Integer> ids);
	public Optional<Artist> getArtistById(int id);
	public String fetchArtistById(int id);
	public Artist extracrArtistById(int id);
	
	public String registerOrUpdateArtist(Artist artist);
	public String hikeArtistFee(int id,double percentage);
	
	public String deleteAllArtist();
	public String deleteAllArtistById(Iterable<Integer> ids);
}
