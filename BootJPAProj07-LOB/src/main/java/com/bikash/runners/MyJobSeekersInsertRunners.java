package com.bikash.runners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bikash.entity.JobSeekers;
import com.bikash.service.IJobSeekersService;

//@Component    //we have two runners so i am disabling this by commenting 
public class MyJobSeekersInsertRunners implements CommandLineRunner {

	@Autowired
	private IJobSeekersService service;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter JS Name :");
			String name=sc.next();
			
			System.out.println("Enter JS Address :");
			String address=sc.next();
			
			System.out.println("Enter JS Photo path");
			String picturePath=sc.next();
			
			System.out.println("Enter JS Resume path");
			String resumePath=sc.next();
			
			FileInputStream fis=new FileInputStream(picturePath);
			byte[] pictureData=new byte[fis.available()]; //available method will give the size
			pictureData=fis.readAllBytes();
			
			File file=new File(resumePath);
			FileReader fr=new FileReader(file);
			char[] resumeData=new char[(int) file.length()];
			fr.read(resumeData);
			
			System.out.println("Are you Indian (True / False)");
			boolean indian=sc.nextBoolean();
			
			JobSeekers js=new JobSeekers(name, address, pictureData, resumeData,indian);
			 
			String msg=service.addJobSeekers(js);
			System.out.println(msg);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
