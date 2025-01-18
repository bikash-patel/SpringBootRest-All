package com.bikash.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name = "BANK_ACCOUNT")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class BankAccount {
	
	@Id
	@SequenceGenerator(name ="bankseq1",sequenceName = "bank_seq",initialValue = 10000000,allocationSize = 1)
	@GeneratedValue(generator = "bankseq1",strategy = GenerationType.SEQUENCE)
	private Long accNo;
	
	@Column(length = 20)
	@NonNull
	private String holderName;
	
	@NonNull
	private Double balance;
	
	@Version
	private Integer modificationCount;
	
	@CreationTimestamp
					// @CreationTimestamp Specifies that the annotated field of property is a generated creation timestamp.The timestamp is generated just once, when an entity instance is inserted in the database. 
	@Column(insertable =true,updatable = false)
	private LocalDateTime openingDate;
	
	@UpdateTimestamp
					//@UpdateTimestamp Specifies that the annotated field of property is a generated update timestamp.The timestamp is regenerated every time an entity instance is updated in the database.
	@Column(insertable = false,updatable = true)
	private LocalDateTime lastUpdatedOn;
}
