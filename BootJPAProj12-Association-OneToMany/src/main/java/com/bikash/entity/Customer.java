package com.bikash.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Customer_Info")
@Setter
@Getter
//@NoArgsConstructor
@RequiredArgsConstructor
public class Customer {
	
	public Customer()
	{
		System.out.println("Customer : 0-arg constructor : Parent");
	}
	
	@Id
	@SequenceGenerator(name = "seq1",sequenceName = "cus_seq",initialValue = 10000,allocationSize = 1)
	@GeneratedValue(generator = "seq1",strategy = GenerationType.SEQUENCE)
	private Integer cId;
	
	@NonNull
	@Column(length = 20)
	private String cName;
	
	@NonNull
	@Column(length = 20)
	private String cAddress;
	
	//For building one-to-many association
	@OneToMany(targetEntity = PhoneNumber.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "cust",orphanRemoval = true)
	// Here mappedBy method we can use instead of JoinColumn but its possible only at one side in one-to-many mapping
	// but we can use this at any side in one-to-one or in many-to-many , but in one side it must JoinColumn should be there
	//@JoinColumn(name = "CUSTOMER_ID",referencedColumnName = "CID")
	
	//orphanRemoval is possible only in one-to-one and one-to-many,is specifically for removing entities when they are removed from a relationship.
	//When you remove a child entity from the collection or disassociate it from its parent, it is automatically deleted from the database
	private Set<PhoneNumber> numberInfo;

	//alt+shift+s -> s
	@Override
	public String toString() {
		return "Customer [cId=" + cId + ", cName=" + cName + ", cAddress=" + cAddress + "]";
	}
	
	
}
