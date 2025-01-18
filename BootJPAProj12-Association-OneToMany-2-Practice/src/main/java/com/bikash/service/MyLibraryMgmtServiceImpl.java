package com.bikash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikash.entity.Books;
import com.bikash.entity.Library;
import com.bikash.repository.MyBooksRepo;
import com.bikash.repository.MyLibraryRepo;

@Service
public class MyLibraryMgmtServiceImpl implements IMyLibraryMgmtService {

	
	@Autowired
	private MyLibraryRepo libraryRepo;
	@Autowired
	private MyBooksRepo bookRepo;
	
	@Override
	public String registerLibWithBook(Library lib) {
		int id=libraryRepo.save(lib).getLid();
		return "Library added with ID : "+id;
	}
	@Override
	public String registerBookWithLib(List<Books> book) {
		bookRepo.saveAll(book);
		return "Books added to library";
	}
}
