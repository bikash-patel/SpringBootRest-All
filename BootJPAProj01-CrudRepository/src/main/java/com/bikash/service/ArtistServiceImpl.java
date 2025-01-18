package com.bikash.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikash.entity.Artist;
import com.bikash.repository.IArtistRepository;

@Service
public class ArtistServiceImpl implements IArtistService {
	
	@Autowired
	private IArtistRepository artistRepo;

	@Override
	public String registerArtist(Artist artist) {
		System.out.println("Proxcy Class "+artistRepo.getClass());
		Artist artist1=artistRepo.save(artist);
		System.out.println("Data Isertion details : "+artist1);
		return artist1.getAid()==null?"Data not saved (Not Inserted)":"Data saved (Inserted)";
	}

	@Override
	public boolean checkIdAvailable(Integer id) {
		return artistRepo.existsById(id);
	}

	@Override
	public Long totalArtist() {
		long totalArtist=artistRepo.count();
		return totalArtist;
	}

	/*@Override
	public String registerArtistBatch(List<Artist> list) {
		Iterable<Artist> iArtist=artistRepo.saveAll(list);
		List<Integer> idList=new ArrayList<Integer>();
		
		iArtist.forEach(id->{
			idList.add(id.getAid());
		});
		
		return idList.size()+" Number of Artist Register with IDs : "+idList;
	}*/
	
	
	
	/*@Override
	public String registerArtistBatch(List<Artist> list) {
		List<Artist> list1=(ArrayList<Artist>) artistRepo.saveAll(list);
		List<Integer> idList=list1.stream().map(art->art.getAid()).collect(Collectors.toList());
		return idList.size()+" no. of Artist saved with ID "+idList;
	}*/
	
	
	@Override
	public String registerArtistBatch(List<Artist> list) {
		Iterable<Artist> itr=artistRepo.saveAll(list);
		List<Integer> idList=StreamSupport.stream(itr.spliterator(), false).map(str->str.getAid()).collect(Collectors.toList());
		return idList.size()+" number of Artist saved with ID "+idList;
	}

	
	@Override
	public Iterable<Artist> findAllArtist() {
		Iterable<Artist> allArtist=artistRepo.findAll();
		return allArtist;
	}

	@Override
	public Iterable<Artist> findAllArtistByIds(Iterable<Integer> ids) {
		Iterable<Artist> iterable=artistRepo.findAllById(ids);
		return iterable;
	}

	//Returning as optional object 
	@Override
	public Optional<Artist> getArtistById(int id) {
		Optional<Artist> optional=artistRepo.findById(id);
		return optional;
	}

	//Returning as String
	@Override
	public String fetchArtistById(int id) {
		Optional<Artist> optional=artistRepo.findById(id);
		return optional.isPresent()?"Employee details : "+optional.get():"Employee not found";
	}

	//Returning as entity object (Best Approach) Industry Standard Approach
	@Override
	public Artist extracrArtistById(int id) {
		/*Optional<Artist> opt=artistRepo.findById(id);
		if(opt.isEmpty())
			 throw new IllegalArgumentException("Artist not found");
		return opt.get();*/
		
		return artistRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Artist not found"));  
		//If a value is present, returns the value, otherwise throws NoSuchElementException.
	}

	@Override
	public String registerOrUpdateArtist(Artist artist) {
		Artist art=artistRepo.save(artist);
		if(artistRepo.existsById(artist.getAid()))
			return art.getAname()+" Artist value updated ";
		return art.getAname()+" Artist register ";
	}

	@Override
	public String hikeArtistFee(int id, double percentage) {
		Optional<Artist> opt=artistRepo.findById(id);
		if(artistRepo.existsById(id))
		{
			Artist artist=opt.get();
			artist.setFees(artist.getFees()+(artist.getFees()*percentage/100.0f));
			artistRepo.save(artist);
			return artist.getAname()+" fee hiked by "+percentage+"%";
		}
		return "Artist not found";
	}
	
	@Override
	public String deleteAllArtist() {
		long count=artistRepo.count();
		artistRepo.deleteAll();
		return count+" number of Artist deleted";
	}
	
	@Override
	public String deleteAllArtistById(Iterable<Integer> ids) {
				
		Iterable<Artist> list=artistRepo.findAllById(ids);
		
		
		/*	long count=Stream.of(ids).count();
		   
		This above line of code is always returning 1 because Stream.of method always aspect
		var...args or an array of elements, not an Iterable. When we pass an Iterable<Artist>
		to Stream.of(), it treats the entire Iterable as a single element, 
	    resulting in a count of 1,
		 
		 */
		
		long count=StreamSupport.stream(list.spliterator(), false).count();
		
		artistRepo.deleteAllById(ids);
		return count+" Number of Artist deleted";
	}
}
