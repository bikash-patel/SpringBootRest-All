package com.bikash.runners;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bikash.entity.JobSeekers;
import com.bikash.service.IJobSeekersService;

@Component
public class MyJobSeekersRetriveRunners2 implements CommandLineRunner {

	@Autowired
	private IJobSeekersService service;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter JS ID :");
			int id=sc.nextInt();
			Optional<JobSeekers> jobSeeker=service.retriveJobSeekers(id);
			if(jobSeeker.isPresent())
			{
				JobSeekers js=jobSeeker.get();
				int jsId=js.getJsId();
				String jsName=js.getJsName();
				String jsAddrs=js.getJsAddress();
				boolean indian=js.getIsIndian();
				System.out.println("Id : "+jsId+" Name : "+jsName+" Address : "+jsAddrs+" is Indian ? "+indian);
				byte[] picture=js.getPicturePath();
				char[] resume=js.getResumePath();
				
				try(FileOutputStream fos=new FileOutputStream("retiveBikashPhoto.jpg");
					FileWriter fw=new FileWriter("bikashResume.txt");)
				{
					fos.write(picture);
					fos.flush();
					fw.write(resume);
				}
			}
			else
			{
				System.out.println("Job Seekers with id "+id+" not found");
			}
		  }
		catch(Exception e)
		{
			
		}
	}

}
