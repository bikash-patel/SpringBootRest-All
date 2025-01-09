package com.bikash.rest;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikash.model.Farmer;
import com.bikash.model.Friends;
import com.bikash.model.JobSeeker;

@RestController
@RequestMapping("jobseeker-api")
public class MyJobSeekerController {
	
	@GetMapping("/report1")
	public ResponseEntity<JobSeeker> getReport1()
	{
		JobSeeker js=new JobSeeker(101,"Bikash","Khairpali",9668453230L);
		return new ResponseEntity<JobSeeker>(js,HttpStatus.OK);
	}
	
	@GetMapping("/report2")
	public ResponseEntity<Farmer> getReport2()
	{
		Friends frnd=new Friends(101,"Suraj","Khairpali",7077687098L);
		
		Farmer frm=new Farmer();
		frm.setFId(10001); frm.setFName("Bikash"); frm.setFLand("8Acers");
		frm.setFLandArea(new String[] {"Amti","JamDoli"});
		frm.setColors(Set.of("Red","Green","Pink"));
		frm.setFMblNo(List.of(9668453230L,9777374038L));
		frm.setFIDDetails(Map.of("Aadhar","944896361068",
								"PAN","GFHPP7356N",
								"Voter","1234"));
		frm.setFFriends(frnd);
		return new ResponseEntity<Farmer>(frm,HttpStatus.OK);
	}
	
	@GetMapping("/report3")
	public ResponseEntity<List<Farmer>> getReport3()
	{
		Friends frnd1=new Friends(101,"Suraj","Khairpali",7077687098L);
		Friends frnd2=new Friends(102,"Pintu","Khairpali",1892687098L);
		
		Farmer frm1=new Farmer(10001,"Bikash","8Acers",new String[] {"Amti","JamDoli"},
								Set.of("Red","Green","Pink"),
								List.of(9668453230L,9777374038L),
								Map.of("Aadhar","944896361068",
										"PAN","GFHPP7356N",
										"Voter","1234"),
								frnd1);
		
		Farmer frm2=new Farmer(10002,"Bhisma","7Acers",new String[] {"Amti","JamDoli","Sirsaha"},
				Set.of("Blue","Green","Pink"),
				List.of(9178138454L,9777374038L),
				Map.of("Aadhar","944896361222",
						"PAN","GHTPP6566N",
						"Voter","92347"),
				frnd2);
		List<Farmer> list=List.of(frm1,frm2);
		return new ResponseEntity<List<Farmer>>(list,HttpStatus.OK);
	}
}

