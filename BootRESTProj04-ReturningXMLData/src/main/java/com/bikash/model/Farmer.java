package com.bikash.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Farmer {
	private Integer fId;
	private String fName;
	private String fLand;
	private String[] fLandArea;
	private Set<String> colors;
	private List<Long> fMblNo;
	private Map<String,Object> fIDDetails;
	private Friends fFriends;
}
