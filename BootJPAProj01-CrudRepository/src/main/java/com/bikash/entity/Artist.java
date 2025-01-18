package com.bikash.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "Artist_info")  //Optional , if we wont write it will take class name as table
@Data
@AllArgsConstructor  //It will create all-arg constructor 
@NoArgsConstructor  //It will create 0-arg constructor
@RequiredArgsConstructor   //It will create our choice arg constructor
public class Artist {
	@Id
	@Column(name = "AID")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "seq1",sequenceName = "artist_seq",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator = "seq1", strategy = GenerationType.SEQUENCE)
	private Integer aid;
	
	@NonNull   //it means it will participate in our choice constructor
	@Column(name = "ANAME",length = 20)
	private String aname;
	
	@NonNull
	@Column(name = "ATYPE",length = 20)
	private String atype;
	
	//If we wont declared with Column annotation it will take proprties name as column name
	@NonNull
	private Double fees;
}
