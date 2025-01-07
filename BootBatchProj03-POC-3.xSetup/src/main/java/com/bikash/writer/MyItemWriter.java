package com.bikash.writer;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class MyItemWriter implements ItemWriter<String> {

	@Override
	public void write(Chunk<? extends String> chunk) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MyItemWriter.write()");
		chunk.forEach(System.out::println);
	}



}
