package com.bikash.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "Phone_No_Details")
@Setter
@Getter
//@NoArgsConstructor
@RequiredArgsConstructor
public class PhoneNumber {
	
	public PhoneNumber()
	{
		System.out.println("PhoneNumber : 0-arg constructor : Child");
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer regNo; 
	
	@NonNull
	private Long mblNo;

	@NonNull
	@Column(length = 30)
	private String provider;
	
	@NonNull
	@Column(length = 30)
	private String numberType;
	
	//For building one-to-many association
	@ManyToOne(targetEntity = Customer.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "CUSTOMER_ID",referencedColumnName = "cid")
	private Customer cust;

	//Alt+shift+s -> s
	@Override
	public String toString() {
		return "PhoneNumber [regNo=" + regNo + ", mblNo=" + mblNo + ", provider=" + provider + ", numberType="
				+ numberType + "]";
	}
	
	
}
