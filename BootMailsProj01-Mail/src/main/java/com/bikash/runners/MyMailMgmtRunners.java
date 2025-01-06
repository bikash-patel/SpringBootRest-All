package com.bikash.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bikash.service.IMyMailMgmtService;

@Component
public class MyMailMgmtRunners implements CommandLineRunner {

	@Autowired
	private IMyMailMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			String msg=service.shopping(new String[] {"Shirt","Fan","Watch","Bottle"},
										new double[] {2000.0,7000.0,3000.0,750.0},
										new String[] {"sasmitapatel05@gmail.com"});
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
