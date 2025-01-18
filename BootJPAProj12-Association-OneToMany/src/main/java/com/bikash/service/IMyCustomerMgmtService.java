package com.bikash.service;

import java.util.List;

public interface IMyCustomerMgmtService {
	public String saveCustomerParentToChild();
	public String saveCustomerChildToParent();
	
	public void loadDetailsParentToChild();
	public void loadDetailsChildToParent();
	
	public void deleteAllFromParentsAndItsChild();
	public void deleteAllChildOfAParent();
	
	public void addNewChildTOExistingChild();
	public void deleteParentFromChild();
	
	public List<Object[]> getDataBasedOnJoin();
}
