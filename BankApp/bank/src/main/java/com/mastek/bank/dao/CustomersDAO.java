package com.mastek.bank.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.bank.entities.Customers;

@Repository
public interface CustomersDAO extends CrudRepository<Customers, Integer>{

}
