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

import com.bikash.listener.MyListener;
import com.bikash.processor.MyItemProcessor;
import com.bikash.reader.MyItemReader;
import com.bikash.writer.MyItemWriter;

@Configuration
@EnableBatchProcessing
public class MyStudentConfiguration {
	
	@Autowired
	private StepBuilderFactory step;
	
	@Autowired
	private JobBuilderFactory job;
	
	@Autowired
	private MyItemReader reader;
	
	@Autowired
	private MyItemProcessor processor;
	
	@Autowired
	private MyItemWriter writer;
	
	@Autowired
	private MyListener listener;
	
	@Bean
	public Step createStep()
	{
		return step.get("step1")
				.<Double,String>chunk(2)
				.reader(reader)
				.writer(writer)
				.processor(processor)
				.build();
	}
	
	@Bean
	public Job createJob()
	{
		return job.get("job1")
				  .incrementer(new RunIdIncrementer())
				  .listener(listener)
				  .start(createStep())
				  .build();
	}
	
}
