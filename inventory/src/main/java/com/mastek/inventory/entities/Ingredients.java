package com.mastek.inventory.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ingredients {

	private int ingID;
	private String ingName;
	
public Ingredients() {
	// TODO Auto-generated constructor stub
}

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
public int getIngID() {
	return ingID;
}

public void setIngID(int ingID) {
	this.ingID = ingID;
}

public String getIngName() {
	return ingName;
}

public void setIngName(String ingName) {
	this.ingName = ingName;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ingID;
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
	Ingredients other = (Ingredients) obj;
	if (ingID != other.ingID)
		return false;
	return true;
}

@Override
public String toString() {
	return "Ingredients [ingID=" + ingID + ", ingName=" + ingName + "]";
}



}
