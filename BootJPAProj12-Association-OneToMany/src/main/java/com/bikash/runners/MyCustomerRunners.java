package com.bikash.runners;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bikash.service.IMyCustomerMgmtService;
@Component
public class MyCustomerRunners implements CommandLineRunner {

	@Autowired
	private IMyCustomerMgmtService service;
	@Override
	public void run(String... args) throws Exception {
		/*try {
			String msg=service.saveCustomerParentToChild();
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			String msg=service.saveCustomerChildToParent();
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			service.loadDetailsParentToChild();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			service.loadDetailsChildToParent();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			service.deleteAllFromParentsAndItsChild();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			service.deleteAllChildOfAParent();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			service.addNewChildTOExistingChild();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*	try {
				service.deleteAllChildOfAParent();
			} catch (Exception e) {
				e.printStackTrace();
			}*/
		
		/*try {
			service.deleteParentFromChild();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			service.getDataBasedOnJoin().forEach(s->{
							                System.out.println(Arrays.toString(s));
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
