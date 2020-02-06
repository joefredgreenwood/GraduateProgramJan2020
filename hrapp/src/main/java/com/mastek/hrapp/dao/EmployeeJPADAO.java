package com.mastek.hrapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.hrapp.entities.Employee;

@Repository // Declare the DAO layer as repositary to manage data
public interface EmployeeJPADAO extends 
			CrudRepository<Employee, Integer>{ // CrudRepositry<class, primary key type

}
