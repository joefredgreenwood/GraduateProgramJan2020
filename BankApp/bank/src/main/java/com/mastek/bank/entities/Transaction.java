package com.mastek.bank.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="JPA_BANK_TRANSACTIONS")
public class Transaction {

	int transactionId;
	
	@FormParam("transactionValue")
	double transactionValue;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}
	
	
	Account linkedAccount; //MAKE SURE THIS IS ACCOUNT NOT AN INT, YOU FORGET THIS EVERY TIME
	
	@ManyToOne
	@JoinColumn(name="fk_account_number")
	@XmlTransient
	public Account getLinkedAccount() {
		return linkedAccount;
	}

	public void setLinkedAccount(Account linkedAccount) {
		this.linkedAccount = linkedAccount;
	}

	
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public double getTransactionValue() {
		return transactionValue;
	}

	public void setTransactionValue(double transactionValue) {
		this.transactionValue = transactionValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + transactionId;
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
		Transaction other = (Transaction) obj;
		if (transactionId != other.transactionId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionValue=" + transactionValue + "]";
	}


	
	
	
	
}
