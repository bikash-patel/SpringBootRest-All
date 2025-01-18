package com.bikash.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name = "Artist_info")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Artist {
	
	@Id
	@Column(name = "aid")
	private Integer id;
	
	@Column(name = "aname",length = 20)
	@NonNull
	private String name;
	
	@NonNull
	private  String atype;
	
	@NonNull
	private Double fees;
	
}
