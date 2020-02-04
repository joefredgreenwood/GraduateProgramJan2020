package com.mastek.training.myshop;

import java.util.LinkedList;
import java.util.List;

public class ListShoppingCart implements ShoppingCart<Item> { //When you are implementing you must declare the<I> as what you act want.

	List<Item> items; // The <Item> is your class list. This gives you access to lots of list features
	
	public ListShoppingCart() {
		items = new LinkedList<Item>(); //This ensures you have set up a linked list
		
	}
	
	@Override
	public int addItem(Item i) {
		items.add(i);
		return items.size();
	}

	@Override
	public int removeItem(Item i) {
		System.out.println("Index of Item: "+items.indexOf(i));
		items.remove(i); //uses equals method of the item class which we change when changing the hashcode. This is changed below
				return items.size();
	}

	@Override
	public void printItems() {
		System.out.println("Items in Cart");
		for (Item item : items) { //This will mean it will print all items
			System.out.println(item);			
		}
	}

	@Override
	public double getTotalPrice(double tax, double discountPercentage) {
		// TODO Auto-generated method stub
		return 0;
	}

}
