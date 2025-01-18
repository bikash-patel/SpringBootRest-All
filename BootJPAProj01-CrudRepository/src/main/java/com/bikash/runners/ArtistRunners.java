package com.bikash.runners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bikash.controller.ArtistController;
import com.bikash.entity.Artist;

@Component
public class ArtistRunners implements CommandLineRunner {

	@Autowired
	private ArtistController controller;
	
	
	Scanner sc=new Scanner(System.in);
	@Override
	public void run(String... args) throws Exception {
		/*
		try {
			System.out.println("Artist name");
			String name=sc.next();
			System.out.println("Artist Type");
			String type=sc.next();
			System.out.println("Fees per shooting");
			Double fees=sc.nextDouble();
			Artist arstist=new Artist(name,type,fees);
			String msg=controller.insertArtis(arstist);
			System.out.println("Result : " +msg);
		} catch (Exception e) {
			System.out.println("something went wrong");
			e.printStackTrace();
		}*/
		
		/*try {
			System.out.println("Enter id to check id available or not");
			Integer id=sc.nextInt();
			Boolean flag=controller.isIdAvailable(id);
			System.out.println("Is ID available ? "+flag);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			System.out.println("Total Artist "+controller.totolArtist());
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
		/*try {
			Artist a1=new Artist("Prabhas","Hero",8500000.0);
			Artist a2=new Artist("Aamir","Hero",9500000.0);
			Artist a3=new Artist("Saharu","Hero",7500000.0);
			Artist a4=new Artist("Akshya","Hero",8000000.0);
			Artist a5=new Artist("Priyanka","Heroin",6500000.0);
			
			List<Artist> list=List.of(a1, a2, a3,a4,a5);
			
			String msg=controller.registerArtistBatch(list);
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
		
		/*try {
			Iterable<Artist> itr=controller.getAllArtist();
			itr.forEach(art->{
				System.out.println(art);
			});
			
			System.out.println("--------------------------------------------------------");
			itr.forEach(art1->System.out.println(art1));
			
		
			System.out.println("--------------------------------------------------------");
			itr.forEach(System.out::println);
			
			
			System.out.println("--------------------------------------------------------");
			for(Artist art:itr)
			{
				System.out.println(art);
			}
			
			
			System.out.println("--------------------------------------------------------");
			Stream.of(itr).forEach(System.out::println); 
			//forEach does not guarantee order in parallel streams
			
			
			System.out.println("--------------------------------------------------------");
			Stream.of(itr).forEachOrdered(System.out::println); 
			//forEachOrdered preserves the encounter order even in parallel streams.
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
		/*try {
			//controller.getAllArtistByIds(List.of(1001,1002,1003,1021,0001)).forEach(System.out::println);;
			//Above List.of method wont allowed null value but findAllById method can take null value as well
			List<Integer> list=new ArrayList<Integer>();
			list.add(1001);
			list.add(1002);
			list.add(1003);
			list.add(1020);
			list.add(null);
			controller.getAllArtistByIds(list).forEach(System.out::println);;
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
		/*try {
			Optional<Artist> optional=controller.getArtistById(1001);
			String msg=optional.isPresent()?"Employee details : "+optional.get():"Employee not found";
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			System.out.println(controller.extracrArtistById(1002));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
		/*try {
			Artist artist=new Artist(1212,"Honey Sing","Singer",99000.0);
			String msg=controller.registerOrUpdateArtist(artist);
			System.out.println(msg);
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		
		/*try {
			String msg=controller.hikeArtistFeeByPercentage(1777,20.0);
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			String msg=controller.allArtistDelete();
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			//Iterable<Integer> list=Arrays.asList(2001,2002,3003,12,null); //Must not be null in asList
			//Iterable<Integer> list=List.of(2001,2002,15, null); //Must not be null otherwise NullPointerException
			Iterable<Integer> list=List.of(201,202,203,12);
			
			String msg=controller.deleteAllArtistById(list);
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

