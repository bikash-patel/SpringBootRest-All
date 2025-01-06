package com.bikash.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyItemProcessor implements ItemProcessor<Double, String> {

	String grade=null;
	@Override
	public String process(Double item) throws Exception {
		System.out.println("MyItemProcessor.process()");
		if(item>=90)
		{
			grade=item+" mark with O grade";
		}
		else if(item>=80 && item<90)
		{
			grade=item+" mark with A+ grade";
		}
		else if(item>=70 && item<80)
		{
			grade=item+" mark with A grade";
		}
		else if(item>=60 && item<70)
		{
			grade=item+" mark with B grade";
		}
		else if(item>=45 && item<60)
		{
			grade=item+" mark with C grade";
		}
		else if(item>=33 && item<45)
		{
			grade=item+" mark with D grade";
		}
		else
		{
			grade=item+" mark and you have failed";
		}
		return grade;
	}

}
