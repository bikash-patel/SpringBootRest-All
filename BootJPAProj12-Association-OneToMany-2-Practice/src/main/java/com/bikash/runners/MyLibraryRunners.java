package com.bikash.runners;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bikash.entity.Books;
import com.bikash.entity.Library;
import com.bikash.service.IMyLibraryMgmtService;

@Component
public class MyLibraryRunners implements CommandLineRunner {

	@Autowired
	private IMyLibraryMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		/*try {
		
			//Library object creation
			Library lib=new Library("PanchayatLib",1200);
			
			//Association object creation
			Books b1=new Books("Java","JamesGosle");
			Books b2=new Books("Python","Bikash");
			
			//Set Child to Parent
			List<Books> list=new ArrayList<Books>();
			list.add(b1); list.add(b2);
			lib.setBooks(list);
			
			//Set Parent to child
			b1.setLib(lib); b2.setLib(lib);
			String msg=service.registerLibWithBook(lib);
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			//Parent object creation
			Library lib=new Library("MGDCLib",2000);
			
			//Associated object creation
			Books b1=new Books("PolSC","Jages Kallis");
			Books b2=new Books("History","Steve Mess");
			
			List<Books> books=new ArrayList<Books>();
			books.add(b1); books.add(b2);
			
			//Set Parent to Child
			b1.setLib(lib); b2.setLib(lib);
			
			//set Child to Parent
			lib.setBooks(books);
			
			String msg=service.registerBookWithLib(books);
			System.out.println(msg);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
