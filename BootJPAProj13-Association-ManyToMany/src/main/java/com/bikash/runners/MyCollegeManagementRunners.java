package com.bikash.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bikash.service.IMyCollegeMgmtService;

@Component
public class MyCollegeManagementRunners implements CommandLineRunner {

	@Autowired
	private IMyCollegeMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		/*try {
			service.saveDetailFromParentToChild();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			service.saveDetailFromChildToParent();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			service.loadDetailsFromParentToChild();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
