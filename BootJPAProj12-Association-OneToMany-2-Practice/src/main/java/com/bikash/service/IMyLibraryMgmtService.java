package com.bikash.service;

import java.util.List;

import com.bikash.entity.Books;
import com.bikash.entity.Library;

public interface IMyLibraryMgmtService {
	public String registerLibWithBook(Library lib);
	
	public String registerBookWithLib(List<Books> book);
}
