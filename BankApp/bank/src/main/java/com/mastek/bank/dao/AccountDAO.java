package com.mastek.bank.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.bank.entities.Account;

@Repository
public interface AccountDAO extends CrudRepository<Account, Integer>{

}
