package com.bikash.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name = "Person_Details")
@NoArgsConstructor
@RequiredArgsConstructor
public class PersonDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pId;
	
	@Column(length = 20)
	@NonNull
	private String pName;
	
	@Column(length = 20)
	@NonNull
	private String pAddress;
	
	@NonNull
	private LocalDate dob;
	
	@NonNull
	private LocalTime tob;
	
	@NonNull
	private LocalDateTime doj;
}
