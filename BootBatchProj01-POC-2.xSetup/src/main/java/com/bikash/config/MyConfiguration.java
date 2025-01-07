package com.bikash.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bikash.listener.MyJobExecListener;
import com.bikash.processor.MyItemProcessor;
import com.bikash.reader.MyItemReader;
import com.bikash.writer.MyItemWriter;

@Configuration
@EnableBatchProcessing
public class MyConfiguration {
	
	@Autowired
	private StepBuilderFactory step;
	
	@Autowired
	private JobBuilderFactory job;
	
	@Autowired
	private MyJobExecListener listener;

	@Autowired
	private MyItemReader reader;
	
	@Autowired
	private MyItemProcessor processor;
	
	@Autowired
	private MyItemWriter writer;
	
	@Bean
	public Step createStep()
	{
		System.out.println("MyConfiguration.createStep()");
		return step.get("step1")
		.<String,String>chunk(2)  //chunk size 2 means read the data one by one , process the 
 		.reader(reader)           //data on by one but write 2 at time as chunk size is 2  
		.writer(writer)   
		.processor(processor) 
		.build();
	}
	
	@Bean
	public Job createJob()
	{
		System.out.println("MyConfiguration.createJob()");
		return job.get("Job1")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.start(createStep())  //Providing Step1 from where it will start
				.build();
				
	}
	
	
}
