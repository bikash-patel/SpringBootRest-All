package com.bikash.entity;

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
@Table(name = "Job_Seeker")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class JobSeeker {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NonNull
	@Column(length = 30)
	private String jName;

	@NonNull
	@Column(length = 30)
	private String jAddrs;

	@NonNull
	@Column(length = 30)
	private String jQlfication;

}
