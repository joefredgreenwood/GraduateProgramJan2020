package com.mastek.inventory.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.inventory.entities.Category;


@Repository
public interface CategoryDAO extends 
CrudRepository<Category, Integer>{ // CrudRepositry<class, primary key type

}