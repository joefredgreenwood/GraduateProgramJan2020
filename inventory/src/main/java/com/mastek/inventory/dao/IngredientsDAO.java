package com.mastek.inventory.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.inventory.entities.Ingredients;


@Repository
public interface IngredientsDAO extends 
CrudRepository<Ingredients, Integer>{ // CrudRepositry<class, primary key type

}
