package com.bikash.listener;

import java.util.Date;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class MyJobExecListener implements JobExecutionListener {
	
	Long timeStart,endStart;

	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("Job is about to begin at "+new Date());
		timeStart=System.currentTimeMillis();
		System.out.println("Job status : "+jobExecution.getStatus());
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("Job is ended at "+new Date());
		endStart=System.currentTimeMillis();
		System.out.println("Job Execution Time : "+(endStart-timeStart));
		System.out.println("Execution status "+jobExecution.getExitStatus());
	}
}
