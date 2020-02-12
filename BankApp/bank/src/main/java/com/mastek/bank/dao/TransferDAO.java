package com.mastek.bank.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mastek.bank.entities.Transfer;

public interface TransferDAO extends MongoRepository<Transfer, Integer>{

}
