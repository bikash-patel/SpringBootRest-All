package com.bikash.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.bikash.entity.Artist;
import com.bikash.repository.IMyArtist;

@Service
public class MyArtistServiceImpl implements IMyArtistService {

	@Autowired
	private IMyArtist artistRepo;
	
	@Override
	public String deleteArtistInBatch(List<Integer> ids) {
		List<Artist> found=artistRepo.findAllById(ids);
		artistRepo.deleteAllByIdInBatch(ids);
		return found.size()+" number of Artist deleted ";
	}
	
	@Override
	public List<Artist> searchArtistByGivenData(String name, Double fees) {
		
		Artist art=new Artist();
		art.setName(name); art.setFees(fees);
		Example<Artist> example=Example.of(art);
		List<Artist> list=artistRepo.findAll(example);
		return list;
	}
	
	@Override
	public Optional<Artist> loadById(int id) {
		return artistRepo.findById(id);
	}
	
	@Override
	public Artist loadArtistRefById(int id) {
		// TODO Auto-generated method stub
		return artistRepo.getReferenceById(id);
	}

}
