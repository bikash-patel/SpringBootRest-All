package com.bikash.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Student_Info")
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class Student {
	
	@Id
	@SequenceGenerator(name = "seq_1",sequenceName = "student_seq1",initialValue = 100000,allocationSize = 1)
	@GeneratedValue(generator = "seq_1",strategy = GenerationType.SEQUENCE)
	private Integer sId;
	
	@NonNull
	@Column(length = 30)
	private String sName;
	
	@NonNull
	@Column(length = 30)
	private String sAddress;
	
	@ManyToMany(targetEntity = Faculty.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "studentInfo")
	private Set<Faculty> facultyInfo=new HashSet<Faculty>();;

	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sName=" + sName + ", sAddress=" + sAddress + "]";
	}
	
	
}
