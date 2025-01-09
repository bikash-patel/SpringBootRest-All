package com.bikash.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Friends {
	private Integer fId;
	private String fName;
	private String fAddress;
	private Long fMblNo;
}
