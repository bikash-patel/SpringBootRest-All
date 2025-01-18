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
@Table(name = "Artist_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Artist {
	@Column(name = "AID")
	@Id
	@SequenceGenerator(name = "seq2" , sequenceName = "artist_seq2",initialValue = 2001,allocationSize = 1)
	@GeneratedValue(generator = "seq2",strategy = GenerationType.SEQUENCE)
	private Integer aid;
	
	@Column(name = "ANAME")
	@NonNull
	private String aname;
	
	@Column(name = "ATYPE")
	@NonNull
	private String atype;
	
	@Column
	@NonNull
	private Double fees;

}
