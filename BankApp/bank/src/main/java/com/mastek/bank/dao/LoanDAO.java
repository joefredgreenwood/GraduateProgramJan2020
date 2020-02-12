package com.mastek.bank.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.bank.entities.Loan;

@Repository
public interface LoanDAO  extends CrudRepository<Loan, Integer>{

}
