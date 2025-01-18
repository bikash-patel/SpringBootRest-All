package com.bikash.entity.product;

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
@Table(name = "twodb_product")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pId;
	@Column(length = 30)
	@NonNull
	private String pName;
	@NonNull
	private Integer pQty;
	@NonNull
	private Double pPrice;
	@Column(length =5)
	@NonNull
	private String pRating;
}
