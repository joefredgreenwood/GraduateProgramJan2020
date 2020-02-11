package com.mastek.bank.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.bank.entities.Transaction;

@Repository
public interface TransactionsDAO extends CrudRepository<Transaction, Integer> {

}
