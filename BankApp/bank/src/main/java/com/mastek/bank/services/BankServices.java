package com.mastek.bank.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastek.bank.dao.AccountDAO;
import com.mastek.bank.dao.CustomersDAO;
import com.mastek.bank.dao.TransactionsDAO;
import com.mastek.bank.dao.TransferDAO;
import com.mastek.bank.entities.Account;
import com.mastek.bank.entities.Customers;
import com.mastek.bank.entities.Transaction;
import com.mastek.bank.entities.Transfer;

@Component
public class BankServices {

	@Autowired
	TransactionsDAO tranDAO;
	
	@Autowired
	CustomersDAO cusDAO;
	
	@Autowired
	AccountDAO accDAO;
	
	@Autowired
	TransferDAO trfDAO;

	
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
	
	@Transactional
	public Transfer assignnTransferToTransaction(int  trfID, int traId) {
		Transfer trf = trfDAO.findById(trfID).get();
		Transaction tra = tranDAO.findById(traId).get();
		
		trf.getTransactionLink().add(tra);
		trf = trfDAO.save(trf);		
		
		return trf;
	}
}
