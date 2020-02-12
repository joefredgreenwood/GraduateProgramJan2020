package com.mastek.bank.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="JPA_BANK_ACCOUNTS")
public class Account {

	int accountNumber;
	String sortCode;
	double balance;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	
	Set<Customers> customerAssigned = new HashSet<>();
	
	
	
	@ManyToMany(mappedBy="accountAssigned")
	public Set<Customers> getCustomerAssigned() {
		return customerAssigned;
	}
	public void setCustomerAssigned(Set<Customers> customerAssigned) {
		this.customerAssigned = customerAssigned;
	}


	Set<Transaction> transactionHistory = new HashSet<>();
	
	
	@OneToMany(mappedBy="linkedAccount",cascade=CascadeType.ALL)
	public Set<Transaction> getTransactionHistory() {
		return transactionHistory;
	}
	public void setTransactionHistory(Set<Transaction> transactionHistory) {
		this.transactionHistory = transactionHistory;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getSortCode() {
		return sortCode;
	}
	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountNumber;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNumber != other.accountNumber)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", sortCode=" + sortCode + ", balance=" + balance + "]";
	}
	
	
	
	
	
}
