package com.bikash.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bikash.service.IMyArtistService;

@Component
public class MyArtistRunners implements CommandLineRunner {

	@Autowired
	private IMyArtistService service;
	@Override
	public void run(String... args) throws Exception {
		service.getArtistByType("Hero").forEach(s->System.out.println(s));
	}

}
