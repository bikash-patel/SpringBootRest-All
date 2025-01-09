package com.bikash.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker {
	private Integer jid;
	private String jname;
	private String jaddress;
	private Long jmblno;
}
