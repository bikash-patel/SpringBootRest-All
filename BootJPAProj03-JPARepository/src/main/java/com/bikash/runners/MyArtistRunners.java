package com.bikash.runners;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bikash.controller.MyController;
import com.bikash.entity.Artist;

@Component
public class MyArtistRunners implements CommandLineRunner {

	@Autowired
	private MyController controller;
	
	@Override
	public void run(String... args) throws Exception {
		
		/*try {
			List<Integer> ids=List.of( 202,203,9090,456);
			String msg=controller.deleteAllArtistByIdInBatch(ids);
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			List<Artist> list=controller.getArtistByGivenData("Bikash",null);
			list.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			Optional<Artist> artist=controller.getArtistById(20005);
			if(artist.isEmpty())
				System.out.println("Artist not found");
			else
			    System.out.println("Artist found :"+artist.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("==================================================");
		
		try {
			Artist artist=controller.getArtistRefById(2005);
		//getArtistRefById returning proxcy object its not the artist object
		//proxcy object is the child class of Entity class(Artist)
		//so here we are referring parent class reference to store child class object
		
		//=> Generated proxcy class is the sub class of Entity class,
		//if we define entity class as final then proxcy class unable to 
		// create, in this case lazy loading wont possible
			System.out.println("Proxcy class " +artist.getClass()+" child class of "+artist.getClass().getSuperclass());
			System.out.println(artist.getId());
			//System.out.println(artist.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
