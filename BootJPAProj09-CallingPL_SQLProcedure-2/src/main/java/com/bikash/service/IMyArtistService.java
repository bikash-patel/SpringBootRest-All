package com.bikash.service;

import java.util.List;

import com.bikash.entity.Artist;

public interface IMyArtistService {
	public List<Artist> getArtistByType(String aType);
}
