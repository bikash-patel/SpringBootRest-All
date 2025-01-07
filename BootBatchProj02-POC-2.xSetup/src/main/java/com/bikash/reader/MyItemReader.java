package com.bikash.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component
public class MyItemReader implements ItemReader<Double> {

	private Double[] items=new Double[] {89.0,95.0,77.0,65.0,25.5};
	int count;
	@Override
	public Double read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		System.out.println("MyItemReader.read()");
		if(count<items.length)
		{
			return items[count++];
		}
		return null;
	}

}
