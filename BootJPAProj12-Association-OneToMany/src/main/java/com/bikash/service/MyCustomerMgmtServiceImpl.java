package com.bikash.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikash.entity.Customer;
import com.bikash.entity.PhoneNumber;
import com.bikash.repository.MyCustomerRepo;
import com.bikash.repository.MyPhoneNumberRepo;

@Service
public class MyCustomerMgmtServiceImpl implements IMyCustomerMgmtService {

	@Autowired
	private MyCustomerRepo custRepo;
	
	@Autowired
	private MyPhoneNumberRepo phoneRepo;
	
	@Override
	public String saveCustomerParentToChild() {
		//Parent class object
		Customer cust=new Customer("Bikash","Bargarh");
		//Child class object
		PhoneNumber phNo1=new PhoneNumber(9668453230L,"Airtel","Office");
		PhoneNumber phNo2=new PhoneNumber(7077687098L,"Jio","Residence");
		
		//Set Child obj to Parent
		Set<PhoneNumber> phn=new HashSet<PhoneNumber>(); //We can not use Set.of ,because its imuteable
		phn.add(phNo1); phn.add(phNo2);
		cust.setNumberInfo(phn);
		
		//Set Parent obj to Child
		phNo1.setCust(cust);
		phNo2.setCust(cust);
		
		//save parent object
		int id=custRepo.save(cust).getCId();
		return "Parent to Child saved with ID : "+id;
	}
	@Override
	public String saveCustomerChildToParent() {
		//Parent class object creation
		Customer cust=new Customer("Suraj","Bargarh");
		
		//Child class object creation
		PhoneNumber phNo1=new PhoneNumber(9178641024L,"VI","Residence");
		PhoneNumber phNo2=new PhoneNumber(9777374038L,"Airtel","Residence");
		
		//Set parent object to child
		phNo1.setCust(cust);
		phNo2.setCust(cust);
		
		//Set child object to parent
		Set<PhoneNumber> numbers=new HashSet<PhoneNumber>();
		numbers.add(phNo1); numbers.add(phNo2);
		cust.setNumberInfo(numbers);
		
		
		phoneRepo.saveAll(numbers);
		return "Child to Parent saved";
	}
	
	@Override
	public void loadDetailsParentToChild() {
		Iterable<Customer> details=custRepo.findAll();
		details.forEach(cust-> {
								System.out.println("Parent : "+cust);
							
								//Associated child object
								Set<PhoneNumber> phnNumber=cust.getNumberInfo();
								phnNumber.forEach(num->System.out.println("Child "+phnNumber));
								}
		                      );
	}
	
	@Override
	public void loadDetailsChildToParent() {
		Iterable<PhoneNumber> numbers=phoneRepo.findAll();
		numbers.forEach(num->{
							System.out.println("Child : "+num);

							//Parent object
							Customer cust=num.getCust();
							System.out.println("Parent : "+cust);
							
		});
	}
	
	@Override
	public void deleteAllFromParentsAndItsChild() {
		Optional<Customer> opt=custRepo.findById(10001);
		if(opt.isPresent())
		{
			Customer cust=opt.get();
			custRepo.delete(cust);
			System.out.println("Parent and its child deleted");
		}
		else
		{
			System.out.println("Cutomer not found");
		}
	}
	
	@Override
	public void deleteAllChildOfAParent() {
		Optional<Customer> opt=custRepo.findById(10000);
		if(opt.isPresent())
		{
			Customer cust=opt.get();
			//Get all childs
			Set<PhoneNumber> childs=cust.getNumberInfo();
			
			childs.forEach(ch->{
				ch.setCust(null);
				//phoneRepo.delete(ch);  This is not generating delete query for each child
			});
			phoneRepo.deleteAllInBatch(childs);
			System.out.println("All Childs deleted ");
		} 
		else
		{
			System.out.println("Customer not found");
		}
	}
	@Override
	public void addNewChildTOExistingChild() {
		Optional<Customer> opt=custRepo.findById(10000);
		if(opt.isPresent())
		{
			Customer cust=opt.get();
			Set<PhoneNumber> childs=cust.getNumberInfo();
			PhoneNumber ph=new PhoneNumber(9777374038L,"vi","home");
			//set/linked to parent 
			ph.setCust(cust);
			childs.add(ph);
			custRepo.save(cust);
			System.out.println("Child added ");
		}
		else
		{
			System.out.println("Customer not found");
		}
	}
	
	@Override
	public void deleteParentFromChild() {
		Optional<Customer> opt= custRepo.findById(10000);
		if(opt.isPresent())
		{
			Customer cust=opt.get();
			Set<PhoneNumber> childs=cust.getNumberInfo();
			childs.forEach(ph->{
				phoneRepo.delete(ph);
			});
			System.out.println("Child and its parent deleted");
		}
		else
		{
			System.out.println("Customer not found");
		}
		
	}
	
	@Override
	public List<Object[]> getDataBasedOnJoin() {
		return custRepo.loadDataUsingJoin();
	}
}
