package com.bikash.repository;

import org.springframework.data.repository.CrudRepository;

import com.bikash.entity.Artist;

public interface IArtistRepository extends CrudRepository<Artist,Integer> {

}
