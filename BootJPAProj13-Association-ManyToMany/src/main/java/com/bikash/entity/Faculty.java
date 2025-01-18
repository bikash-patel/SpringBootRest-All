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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Faculty_Info")
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class Faculty {
	
	@Id
	@SequenceGenerator(name = "seq1",sequenceName = "faculty_seq1",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator = "seq1",strategy = GenerationType.SEQUENCE)
	private Integer fId;
	
	@NonNull
	@Column(length = 30)
	private String fName;
	
	@NonNull
	@Column(length = 30)
	private String fAddress;
	
	@ManyToMany(targetEntity = Student.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "Faculty_Student_Info",
			   joinColumns = @JoinColumn(name="faculty_id",referencedColumnName = "fId"),
			   inverseJoinColumns = @JoinColumn(name="student_id",referencedColumnName = "sId"))
	private Set<Student> studentInfo=new HashSet<Student>();
	

	//toString
	@Override
	public String toString() {
		return "Faculty [fId=" + fId + ", fName=" + fName + ", fAddress=" + fAddress + "]";
	}
	
	
}
