package com.mastek.bank.entities;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="JPA_TRANSFER")
public class Transfer {

	int id;
	String fromAccount;
	String toAccount;
	double ammount;
	String description;
	
	Set<Transaction> transactionLink = new HashSet<>();
	
	
	
	public Set<Transaction> getTransactionLink() {
		return transactionLink;
	}
	public void setTransactionLink(Set<Transaction> transactionLink) {
		this.transactionLink = transactionLink;
	}
	
	
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}
	public String getToAccount() {
		return toAccount;
	}
	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}
	public double getAmmount() {
		return ammount;
	}
	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Transfer other = (Transfer) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Transfer [id=" + id + ", fromAccount=" + fromAccount + ", toAccount=" + toAccount + ", ammount="
				+ ammount + ", description=" + description + "]";
	}
	
	
	
}
