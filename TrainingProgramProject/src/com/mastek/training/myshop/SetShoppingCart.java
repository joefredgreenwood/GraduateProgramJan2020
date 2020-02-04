package com.mastek.training.myshop;

import java.util.Set;
import java.util.TreeSet;

public class SetShoppingCart implements ShoppingCart<Item> {

	Set<Item> items;
	//Use HashSet to manage unique items in random order
	public SetShoppingCart() {
		//items = new HashSet<>(); //<> diamond operator just represents Items with new keyword. Stores in random order
		items = new TreeSet<>(); //Using treeset stores them in a sorted order
	}
	
	@Override
	public int addItem(Item i) {
		items.add(i);		
		return items.size();
	}

	@Override
	public int removeItem(Item i) {
		items.remove(i);
		return items.size();
	}

	@Override
	public void printItems() {
		System.out.println("Items in Cart");
		for (Item item : items) {
			System.out.println(item);
		}
			
	}

	@Override
	public double getTotalPrice(double tax, double discountPercentage) {
		// TODO Auto-generated method stub
		return 0;
	}

}
