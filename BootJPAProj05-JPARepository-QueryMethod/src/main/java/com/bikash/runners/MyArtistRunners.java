package com.bikash.runners;

import java.util.Arrays;
import java.util.List;

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
		
		//artistRepo.getAllArtist().forEach(System.out::println);
		
		//artistRepo.getAllArtistByRange(8000.0,20000.0).forEach(System.out::println);
		
		//artistRepo.fetchAllArtistByRange(8000.0,20000.0).forEach(System.out::println);
		
		//artistRepo.getArtistByType("Hero","Student","Actor").forEach(System.out::println);
		
		/*artistRepo.fetchArtistByType("Hero","Student","Actor").forEach(row->
			    System.out.println(Arrays.toString(row))
				);*/
		
		//artistRepo.loadArtistByType("B%").forEach(System.out::println);
		
		//System.out.println(artistRepo.getArtistByName("Anil"));
		
		/*Object obj=artistRepo.loadArtistByName("Anil");
		Object[] res=(Object[]) obj;
		System.out.println(Arrays.toString(res));*/ //can not call Arrays.toString expect object[] as input
		
		//System.out.println(artistRepo.fetchArtistByName("Anil"));
		
		/*	System.out.println("Number of unique name : "+artistRepo.fetchArtistCount());
			
			System.out.println("Maximun fees : "+artistRepo.fetchMaxFeesFromArtist());
			
			System.out.println("Minimun fees : "+artistRepo.fetchMinFeesFromArtist());
			
			System.out.println("Spending total fees per month for paying salary: "+artistRepo.fetchTotalFeesFromArtist());*/
		
		
		
		//==========================================Non-Select Query=======================================
		
		
		/*int count=artistRepo.updateArtistSalary("Hero",5.0);
		System.out.println("Total number of Artist effected : "+count);*/
		
		/*int count=artistRepo.deleteArtistBySalaryRange(8000.0,20000.0);
		System.out.println(count+" Artist removed");*/
		
		
		//==========================================Native SQL Query=======================================
		
		System.out.println(artistRepo.getCurrentDateTime());
	}

}
