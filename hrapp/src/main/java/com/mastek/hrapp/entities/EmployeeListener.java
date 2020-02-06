package com.mastek.hrapp.entities;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.springframework.stereotype.Component;

@Component // class is initialised by Spring Application COntext
public class EmployeeListener {
	//@Lifecycle-Event (What's happened e.g. before inserting
	// all methods will be public void <method name> (Entity e)


	@PrePersist // This is for before inserting
	public void beforeEMPInsert (Employee e) {
		System.out.println("Before employee insert");
		System.out.println("Raise laptop request for "+e.getEmpno());
	}

	@PostPersist //This will be after a record is inserted
	public void afterINsert (Employee e) {
		System.out.println("After Employee Insert");
		System.out.println("Screen name generated: "+e.getName()+e.getEmpno());
	}

	@PreUpdate // Before updating
	public void beforeUpdate(Employee e) {
		System.out.println("Before Update: "+e);
	}

	@PostUpdate // After updating
	public void afterUpdate(Employee e) {
		System.out.println("After Update: "+e);
	}


	@PostLoad
	public void afterEMPLoad(Employee e) {
		System.out.println("Employee Fetched: "+e);	
	}

	@PreRemove
	public void beforeRemoveEmployee(Employee e) {
		System.out.println("Disable profile for "+e.getEmpno());
	}
}