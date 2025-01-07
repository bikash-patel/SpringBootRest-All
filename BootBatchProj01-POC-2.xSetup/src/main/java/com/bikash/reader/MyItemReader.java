package com.bikash.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component
public class MyItemReader implements ItemReader<String> {

	private String[] items=new String[] {"Laptop","Trimmer","Earphone","Mobile","Bike"};
	int count=0;
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		System.out.println("MyItemReader.read()");
		if(count<items.length)
		{
			return items[count++];  // Here read data one by one from Array
		}
		return null;
	}

}
