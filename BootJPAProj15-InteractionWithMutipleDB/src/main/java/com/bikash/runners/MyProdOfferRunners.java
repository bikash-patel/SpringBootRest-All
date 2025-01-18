package com.bikash.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bikash.entity.offeres.Offeres;
import com.bikash.entity.product.Product;
import com.bikash.service.IProdOfferMgmtService;

@Component
public class MyProdOfferRunners implements CommandLineRunner {

	@Autowired
	private IProdOfferMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		/*try {
			Product prod=new Product("Bed",1,10000.0,"4.7 *");
			Offeres offer=new Offeres("Dwali",1000.0);
			String msg=service.registerProdAndOffers(prod,offer);
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			List<Product> list1=service.getAllProduct();
			List<Offeres> list2=service.getAllOfferes();
			System.out.println(list1);
			System.out.println(list2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
