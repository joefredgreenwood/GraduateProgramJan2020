package com.mastek.inventory.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.inventory.entities.Customers;


@Repository
public interface CustomersDAO extends 
CrudRepository<Customers, Integer>{ // CrudRepositry<class, primary key type

}
