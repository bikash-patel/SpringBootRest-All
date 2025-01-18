package com.bikash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.bikash.entity.Artist;
import com.bikash.repository.IMyArtistRepo;

@Service
public class ArtistServiceImpl implements IArtistService {
	
	@Autowired
	private IMyArtistRepo artistRepo;

	@Override
	public Iterable<Artist> getAllArtistBySorting(boolean ascOrder,String...props) {
		
		Sort sort=ascOrder?Sort.by(Direction.ASC,props):Sort.by(Direction.DESC,props);
		
		Iterable<Artist> list=artistRepo.findAll(sort);
		return list;
	}

	@Override
	public Page<Artist> getEmployeeByPaging(int pageNo, int pageSize) {
		Pageable page=PageRequest.of(pageNo, pageSize);
		Page<Artist> page1=artistRepo.findAll(page);
		return page1;
	}

	@Override
	public void getEmployeePageByPage(int pageSize, boolean isASC, String... props) {
		long count=artistRepo.count();
		long pageCount=count/pageSize;
		if(count%pageSize!=0)
			++pageCount;
		Sort sort=isASC?Sort.by(Direction.ASC, props):Sort.by(Direction.DESC, props);
		for(int i=0;i<pageCount;++i) {
			//Get Pageable object for every page
			Pageable page=PageRequest.of(i, pageSize, sort);
			//Get each page record
			Page<Artist> page1=artistRepo.findAll(page);
			//display each record
			page1.forEach(System.out::println);
			System.out.println("-----------------------------("+(page.getPageNumber()+1)+"/"+page1.getTotalPages()+")-----------------------------");
		}
	}

}
