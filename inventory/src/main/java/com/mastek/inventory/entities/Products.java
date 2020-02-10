package com.mastek.inventory.entities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Products {
	
	
	private int productID;
	private String name;
	private double unitPrice;
	
public Products() {
	// TODO Auto-generated constructor stub
}

Set<Orders> orderList = new HashSet<>();

	private Category currentCategory;

	@ManyToOne //1 employee is associated with one of the many departments
	@JoinColumn(name="fk_category_number")
	public Category getCurrentCategory() {
		return currentCategory;
	}



	public void setCurrentCategory(Category currentCategory) {
		this.currentCategory = currentCategory;
	}







	



@ManyToMany(mappedBy="productList")
public Set<Orders> getOrderList() {
	return orderList;
}



public void setOrderList(Set<Orders> orderList) {
	this.orderList = orderList;
}



@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
public int getProductID() {
	return productID;
}



public void setProductID(int productID) {
	this.productID = productID;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getUnitPrice() {
	return unitPrice;
}

public void setUnitPrice(double unitPrice) {
	this.unitPrice = unitPrice;
}

@Override
public String toString() {
	return "Products [productID=" + productID + ", name=" + name + ", unitPrice=" + unitPrice + "]";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + productID;
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
	Products other = (Products) obj;
	if (productID != other.productID)
		return false;
	return true;
}


	

}
