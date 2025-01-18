package com.bikash.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.bikash.entity.Artist;

public interface IMyArtistRepo extends CrudRepository<Artist,Integer>, PagingAndSortingRepository<Artist,Integer> {

}
