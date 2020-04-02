package com.mastek.bank.services;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastek.bank.api.AccountAPI;
import com.mastek.bank.api.CustomerAPI;
import com.mastek.bank.api.TransactionAPI;
import com.mastek.bank.dao.AccountDAO;
import com.mastek.bank.dao.CustomersDAO;
import com.mastek.bank.dao.TransactionsDAO;
import com.mastek.bank.dao.TransferDAO;
import com.mastek.bank.entities.Account;
import com.mastek.bank.entities.Customers;
import com.mastek.bank.entities.Transaction;
import com.mastek.bank.entities.Transfer;

@Component
public class BankServices implements CustomerAPI, TransactionAPI, AccountAPI{

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

	@Override
	public Iterable<Customers> listAllEmployees() {
		// TODO Auto-generated method stub
		return cusDAO.findAll();
	}



	@Override
	public Customers findByCustNo(int custNo) {
		// TODO Auto-generated method stub
		return cusDAO.findById(custNo).get();
	}

	@Override
	public Customers registerNewCustomer(Customers newCustomer) {
		newCustomer = cusDAO.save(newCustomer);
		return newCustomer;
	}

	@Override
	public Iterable<Transaction> listAllTransactions() {
		// TODO Auto-generated method stub
		return tranDAO.findAll();
	}

	@Override
	public Transaction registerNewTransaction(Transaction newTransaction) {
		newTransaction = tranDAO.save(newTransaction);
		return newTransaction;
	}

	@Override
	public Transaction findByTransactionId(int transactionId) {
		// TODO Auto-generated method stub
		return tranDAO.findById(transactionId).get();
	}

	@Override
	public Iterable<Account> listAllAccounts() {
		// TODO Auto-generated method stub
		return accDAO.findAll();
	}

	@Override
	public Account findByAccountId(int accountNumber) {
		// TODO Auto-generated method stub
		return accDAO.findById(accountNumber).get();
	}

	@Override
	public Account registerNewAccount(Account newAccount) {
		newAccount = accDAO.save(newAccount);
		return newAccount;
	}

	@Override
	@Transactional //to fetch all collections
	public Set<Account> getCustomerAcconts(int custNo) {
	    Customers currentCus = cusDAO.findById(custNo).get();
	    int count = currentCus.getAccountAssigned().size();
	    System.out.println(count +" Accounts found");
	    
	    Set<Account> accounts = currentCus.getAccountAssigned();
	    return accounts;
	}

	@Override
	@Transactional
	public Account registerAccountForCustomer(int custNo, Account newAccount) {
	    newAccount = accDAO.save(newAccount);
	  //  newAccount = cusDAO.save(newAccount);
	    assignCustomersToAccount(custNo, newAccount.getAccountNumber());
	    return newAccount;
	}
}
