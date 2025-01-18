package com.bikash.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Books_Info")
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class Books {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bid;
	
	@NonNull
	@Column(length = 30)
	private String bName;
	
	@NonNull
	@Column(length = 30)
	private String bAuthor;
	
	@ManyToOne(targetEntity = Library.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "Lib_id",referencedColumnName = "lid")
	private Library lib;

	//toString
	@Override
	public String toString() {
		return "Books [bid=" + bid + ", bName=" + bName + ", bAuthor=" + bAuthor + "]";
	}
	
	
}
