package com.mastek.bank.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastek.bank.dao.AccountDAO;
import com.mastek.bank.dao.CustomersDAO;
import com.mastek.bank.dao.TransactionsDAO;
import com.mastek.bank.entities.Account;
import com.mastek.bank.entities.Customers;
import com.mastek.bank.entities.Transaction;

@Component
public class BankServices {

	@Autowired
	TransactionsDAO tranDAO;
	
	@Autowired
	CustomersDAO cusDAO;
	
	@Autowired
	AccountDAO accDAO;

	
	@Transactional
	public Transaction assignAccountAndTransactions(int transactionId, int accountNumber) {
		Transaction tran = tranDAO.findById(transactionId).get();
		Account acc = accDAO.findById(accountNumber).get();
		
		tran.setLinkedAccount(acc);
		acc.getTransactionHistory().add(tran);
		
		tranDAO.save(tran);
		accDAO.save(acc);
		
		
		return tran;
	}
	
	@Transactional
	public Customers assignCustomersToAccount(int cusId,int accId) {
		Customers cus = cusDAO.findById(cusId).get();
		Account acc = accDAO.findById(accId).get();
		
		cus.getAccountAssigned().add(acc);
		cus = cusDAO.save(cus);
		
		
		
		
		return cus;
				
				
	}
}
