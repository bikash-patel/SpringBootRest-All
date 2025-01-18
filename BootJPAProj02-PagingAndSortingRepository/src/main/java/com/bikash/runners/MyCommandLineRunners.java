package com.bikash.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.bikash.controller.MyArtistController;
import com.bikash.entity.Artist;

@Component
public class MyCommandLineRunners implements CommandLineRunner {

	@Autowired
	private MyArtistController controller;

	@Override
	public void run(String... args) throws Exception {

		/*try {
			controller.getAllArtistWithSorting(true,"aname","atype").forEach(System.out::println);
			
			//controller.getAllArtistWithSorting(true).forEach(System.out::println);
			//Here we can pass 0 or more than 0 arg in var-arg but Sort.by method not allowing
			//empty or o-param for var-arg
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		/*try {
			controller.showEmployeeByPage(1,2).getContent().forEach(System.out::println);
			
			Page<Artist> page=controller.showEmployeeByPage(3, 2);
			List<Artist> list=page.getContent(); 
			list.forEach(System.out::println);
			System.out.println("--------------------------------------");
			System.out.println("Page No : "+(page.getNumber()+1)+"/"+page.getTotalPages());
			System.out.println("Total number of record in this page :"+page.getNumberOfElements());
			System.out.println("Is the current page is 1st page : "+page.isFirst());
			System.out.println("Is the current page is last page : "+page.isLast());
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			controller.getEmployeePageByPage(3,true,"aname");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
