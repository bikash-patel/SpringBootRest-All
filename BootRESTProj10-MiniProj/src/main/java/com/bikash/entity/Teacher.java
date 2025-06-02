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
@Data
@Table(name = "Teacher_Info")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Teacher {
	
	@Id
	@SequenceGenerator(name = "seq1",sequenceName = "teacher_seq1",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator = "seq1",strategy = GenerationType.SEQUENCE)
	private Integer tid;
	
	@NonNull
	@Column(length = 30)
	private String tname;
	
	@NonNull
	@Column(length = 50)
	private String address;
	
	@NonNull
	@Column(length = 50)
	private String school;
	
	@NonNull
	private Long mblno;
	
}
