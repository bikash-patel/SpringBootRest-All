package com.bikash.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyItemProcessor implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {
		System.out.println("MyItemProcessor.process()");
		String itemBrand=null;
		if(item.equalsIgnoreCase("Laptop"))
		{
			itemBrand=item+" of brand HP";
		}
		else if(item.equalsIgnoreCase("Trimmer"))
		{
			itemBrand=item+" of brand Phillips";
		}
		else if(item.equalsIgnoreCase("Earphone"))
		{
			itemBrand=item+" of brand Boat";
		}
		else if(item.equalsIgnoreCase("Mobile"))
		{
			itemBrand=item+" of brand Apple";
		}
		else if(item.equalsIgnoreCase("Bike"))
		{
			itemBrand=item+" of brand Apachee";
		}
			return itemBrand;
	}
}
