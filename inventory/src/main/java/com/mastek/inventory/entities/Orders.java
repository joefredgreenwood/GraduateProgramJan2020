package com.mastek.inventory.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Orders {

	private int orderNo;
	private double price;
	private int quantity;
	
public Orders() {
	// TODO Auto-generated constructor stub
}

	private Customers currentCustomer;

	@ManyToOne //1 employee is associated with one of the many departments
	@JoinColumn(name="fk_customer_number")
public Customers getCurrentCustomer() {
		return currentCustomer;
	}

	public void setCurrentCustomer(Customers currentCustomer) {
		this.currentCustomer = currentCustomer;
	}

	Set<Products> productList = new HashSet<>();
	
	
	@ManyToMany(cascade=CascadeType.ALL) // configure many to many
	@JoinTable(name="JPA_Order_Products",// provide the join table name
	joinColumns= {@JoinColumn(name="fk_orderNo")}, // foreign key column for current class
	inverseJoinColumns= {@JoinColumn(name="fk_productId")}) // foreign key column for collection	
public Set<Products> getProductList() {
		return productList;
	}

	public void setProductList(Set<Products> productList) {
		this.productList = productList;
	}

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
public int getOrderNo() {
	return orderNo;
}

public void setOrderNo(int orderNo) {
	this.orderNo = orderNo;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}



}
