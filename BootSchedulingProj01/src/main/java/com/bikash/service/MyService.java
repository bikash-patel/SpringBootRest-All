package com.bikash.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MyService {
	public MyService()
	{
		System.out.println("MyService.MyService():: 0-arg constructor");		
	}
	@Scheduled(fixedDelay = 3000)
	public void getReport()
	{
		System.err.println("Welcome to CrazyCoding : "+new Date());
	}
}
