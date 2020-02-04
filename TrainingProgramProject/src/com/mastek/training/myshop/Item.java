package com.mastek.training.myshop;

public class Item 
implements Comparable<Item> // it provides the default sorting for TreeSet
{

	private int itemID;
	private String itemName;
	private double itemQuantity;
	private double unitPrice;

	public Item() { // There should always be a default constructor
		// TODO Auto-generated constructor stub
	}

	public Item(int itemID, String itemName, double unitPrice, int itemQuantity) {//This constructor is used in add
		setItemID(itemID);
		setItemName(itemName);
		setUnitPrice(unitPrice);
		setItemQuantity(itemQuantity);
	}
	
	
	
	public Item(int itemID) { //This constructor is used for remove.
		setItemID(itemID);
	}

	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(double itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return "Item [itemID=" + itemID + ", itemName=" + itemName + ", itemQuantity=" + itemQuantity + ", unitPrice="
				+ unitPrice + "]";
	}

	@Override
	public int hashCode() { //These are really important
		final int prime = 31;
		int result = 1;
		result = prime * result + itemID;
		return result;
	}

	@Override
	public boolean equals(Object obj) { //Really important
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (itemID != other.itemID)
			return false;
		return true;
	}

	@Override //This is the default order. However if the value you want to use isn't unique e.g. price it will treat them as the same so only show one
	public int compareTo(Item anotherItem) {
		// return a nymber
		//+ve: current object is greater than anotherItem
		// 0: current object is equal to anotherItem
		// -ve: current object is less than anotherItem
		//System.out.println("Comparing Items"); ps. you should always comment out print outs after checking they work.
		return this.getItemID()-anotherItem.getItemID(); //This sorts ascending - swap for descending
	}


	

}
