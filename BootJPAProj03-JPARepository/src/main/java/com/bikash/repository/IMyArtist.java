package com.bikash.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikash.entity.Artist;

public interface IMyArtist extends JpaRepository<Artist,Integer> {

}
