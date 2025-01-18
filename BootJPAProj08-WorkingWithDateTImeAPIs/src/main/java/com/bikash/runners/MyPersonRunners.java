package com.bikash.runners;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bikash.entity.PersonDetails;
import com.bikash.service.PersonMgmtServiceImpl;

@Component
public class MyPersonRunners implements CommandLineRunner {

	@Autowired
	private PersonMgmtServiceImpl service;
	@Override
	public void run(String... args) throws Exception {
		/*try {
			
			PersonDetails person=new PersonDetails("Bikash","Odisha",
					LocalDate.of(2001,11,26),LocalTime.of(20,40),
					LocalDateTime.of(2023,3,30,8,30));
			String msg=service.registerPerson(person);
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}	*/
		
		/*try (Scanner sc=new Scanner(System.in);){
			System.out.println("Enter person id : ");
			int id=sc.nextInt();
			String msg=service.getPersonAge(id);
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try (Scanner sc=new Scanner(System.in);){
			System.out.println("Enter person id : ");
			int id=sc.nextInt();
			System.out.println("Age : "+service.getPersonAgeByQuery(id));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		try (Scanner sc=new Scanner(System.in);){
			System.out.println("Enter person id : ");
			int id=sc.nextInt();
			System.out.println(service.getPersonAgeByMySqlQuery(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		}

}
