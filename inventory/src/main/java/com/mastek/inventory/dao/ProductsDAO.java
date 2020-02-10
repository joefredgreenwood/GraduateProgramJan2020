package com.mastek.inventory.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.inventory.entities.Products;


@Repository
public interface ProductsDAO extends 
	CrudRepository<Products, Integer>{ // CrudRepositry<class, primary key type

}


