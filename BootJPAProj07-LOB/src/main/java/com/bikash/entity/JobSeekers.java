package com.bikash.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name = "Job_Seekers")
@NoArgsConstructor
@RequiredArgsConstructor
public class JobSeekers implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer jsId;
	
	@Column(length = 20)
	@NonNull
	private String jsName;
	
	@Column(length = 20)
	@NonNull
	private String jsAddress;
	
	@Lob
	@NonNull
	private byte[] picturePath;
	
	@Lob
	@NonNull
	private char[] resumePath;
	
	@NonNull
	private Boolean isIndian;
	
	

}
