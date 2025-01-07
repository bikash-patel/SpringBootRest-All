package com.bikash.runners;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunners implements CommandLineRunner {

	/*@Autowired
	private Job job;
	
	@Autowired
	private JobLauncher jobLuncher;*/
	
	@Override
	public void run(String... args) throws Exception {
		//Prepare job param
		/*JobParameters param= new JobParametersBuilder().addLong("time",System.currentTimeMillis()).toJobParameters();
		
		//Run the job
		JobExecution execution=jobLuncher.run(job, param);
		System.out.println(execution.getStatus());*/
	}

}
