package com.mastek.inventory.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Categories_JPA")
public class Category {

	private int catID;
	private String name;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getCatID() {
		return catID;
	}

	public void setCatID(int catID) {
		this.catID = catID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	Set<Products> ProductList = new HashSet<>(); 

	
	@OneToMany(mappedBy="currentCategory", cascade=CascadeType.ALL)	
	public Set<Products> getProductList() {
		return ProductList;
	}

	public void setProductList(Set<Products> productList) {
		ProductList = productList;
	}

	public Category() {
	// TODO Auto-generated constructor stub
}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + catID;
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
		Category other = (Category) obj;
		if (catID != other.catID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Category [catID=" + catID + ", name=" + name + "]";
	}

	
	

}
