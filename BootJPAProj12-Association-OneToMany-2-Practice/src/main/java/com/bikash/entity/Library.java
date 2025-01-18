package com.bikash.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Library_Info")
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class Library {
	
	@Id
	@SequenceGenerator(name = "libseq1",sequenceName = "lib_seq1",initialValue = 10000,allocationSize = 1)
	@GeneratedValue(generator = "libseq1",strategy = GenerationType.SEQUENCE)
	private Integer lid;
	
	@NonNull
	@Column(length = 30)
	private String lName;
	
	@NonNull
	private Integer lCapacity;
	
	@OneToMany(targetEntity = Books.class,cascade = CascadeType.ALL,mappedBy = "lib")
	private List<Books> books;

	
	//toString
	@Override
	public String toString() {
		return "Library [lid=" + lid + ", lName=" + lName + ", lCapacity=" + lCapacity + "]";
	}
	 
	
}
