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
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Artist {
	@Column(name = "aid")
	@Id
	private Integer id;
	@NonNull
	@Column(name = "aname",length = 20)
	private String aname;
	@NonNull
	@Column(name = "atype",length = 20)
	private String atype;
	@NonNull
	private Double fees;
}
