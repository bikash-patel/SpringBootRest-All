package com.bikash.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bikash.entity.JobSeeker;
import com.bikash.service.IJobSeekerService;

@Component
public class MyJobSeekersRunner implements CommandLineRunner {

	@Autowired
	private IJobSeekerService service;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("============================Saving Details============================");
		try {
			JobSeeker js1=new JobSeeker("Bikash","Khairpali","BSC");
			JobSeeker js2=new JobSeeker("Premchand","Chikhili","BSC");
			JobSeeker js3=new JobSeeker("Manas","Kesaipali","BSC");
			String msg=service.jobSeekerSaveInGroup(List.of(js1,js2,js3));
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("============================Retriving Details============================");
		try {
			List<JobSeeker> list=(List<JobSeeker>) service.getAllJobSeeker();
			list.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("============================Retriving Details Based On ID============================");
		try {
			String msg=service.getJobSeekerById(1);
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
