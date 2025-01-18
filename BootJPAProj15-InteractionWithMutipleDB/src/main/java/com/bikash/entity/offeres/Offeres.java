package com.bikash.entity.offeres;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name = "twodb_offers")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Offeres {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer oId;
	@Column(length = 30)
	@NonNull
	private String oName;
	@NonNull
	private Double oPrice;
}
