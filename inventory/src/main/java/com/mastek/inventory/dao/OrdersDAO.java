package com.mastek.inventory.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.inventory.entities.Orders;


@Repository
public interface OrdersDAO extends 
CrudRepository<Orders, Integer>{ // CrudRepositry<class, primary key type

}
