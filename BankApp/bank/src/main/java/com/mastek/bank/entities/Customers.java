package com.mastek.bank.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="JPA_CUSTOMERS_BANK")
@XmlRootElement
public class Customers {

	int custNo;
	
	@FormParam("name")
	String name;
	
	@FormParam("address")
	String address;
	
	public Customers() {
		// TODO Auto-generated constructor stub
	}
	
	Set<Account> accountAssigned = new HashSet<>();
	
	@ManyToMany(cascade=CascadeType.ALL) // configure many to many
	@JoinTable(name="JPA_ACCOUNT_CUSTOMER",// provide the join table name
	joinColumns= {@JoinColumn(name="fk_customer_id")}, // foreign key column for current class
	inverseJoinColumns= {@JoinColumn(name="fk_accountId")}) // foreign key column for collection
	@XmlTransient
	public Set<Account> getAccountAssigned() {
		return accountAssigned;
	}

	public void setAccountAssigned(Set<Account> accountAssigned) {
		this.accountAssigned = accountAssigned;
	}

	@Id
	@Column(name="customer_number")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getCustNo() {
		return custNo;
	}

	public void setCustNo(int custNo) {
		this.custNo = custNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + custNo;
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
		Customers other = (Customers) obj;
		if (custNo != other.custNo)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Customers [custNo=" + custNo + ", name=" + name + ", address=" + address + "]";
	}

	

	
	
	
}
