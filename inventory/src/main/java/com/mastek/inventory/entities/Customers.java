package com.mastek.inventory.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Customers_JPA")
@EntityListeners({CustomersListener.class})
public class Customers {

	private int custId;
	private String name;
	private String emailAddress;
	

	
	public Customers() {
	// TODO Auto-generated constructor stub
}
	
Set<Orders> customers = new HashSet<>();

	
@OneToMany(mappedBy="currentCustomer", cascade=CascadeType.ALL)		
public Set<Orders> getCustomers() {
	return customers;
}

public void setCustomers(Set<Orders> customers) {
	this.customers = customers;
}


@Id
@Column(name="customer_id")
@GeneratedValue(strategy=GenerationType.AUTO)
public int getCustId() {
return custId;
}

public void setCustId(int custId) {
	this.custId = custId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmailAddress() {
	return emailAddress;
}

@Column(length=50)
public void setEmailAddress(String emailAddress) {
	this.emailAddress = emailAddress;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + custId;
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
	if (custId != other.custId)
		return false;
	return true;
}

@Override
public String toString() {
	return "Customers [custId=" + custId + ", name=" + name + ", emailAddress=" + emailAddress + "]";
}
	
}
