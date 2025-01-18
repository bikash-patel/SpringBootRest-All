package com.bikash.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bikash.repository.MyArtistRepo;

@Component
public class MyArtistRunners implements CommandLineRunner {

	@Autowired
	private MyArtistRepo artistRepo;
	@Override
	public void run(String... args) throws Exception {
		try {
			//artistRepo.findByAnameEquals("Bikash").forEach(System.out::println);
			//artistRepo.readByAtypeIs("Hero").forEach(System.out::println);
			//artistRepo.getByAtypeIgnoreCase("Hero").forEach(System.out::println);
			//artistRepo.findByAnameStartingWith("Bi").forEach(System.out::println);
			//artistRepo.findByAnameEndingWith("sh").forEach(System.out::println);
			//artistRepo.findByAnameContaining("re").forEach(System.out::println);
			//artistRepo.findByAnameEndingWithOrderByAnameAsc("sh").forEach(System.out::println);
			
			//artistRepo.findByAnameLike("Bi%").forEach(System.out::println);
			artistRepo.findByFeesBetween(40000.0,70000.0).forEach(System.out::println);
			
			//artistRepo.findByAtypeIn("Hero","Villan").forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
