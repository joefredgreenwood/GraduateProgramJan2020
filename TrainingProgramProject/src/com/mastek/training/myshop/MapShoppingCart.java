package com.mastek.training.myshop;

import java.util.Map;
import java.util.TreeMap;

public class MapShoppingCart implements ShoppingCart<Item> {

	
	public Map<Integer, Item> items;
	
	public MapShoppingCart() {
		//items = new HashMap<>(); // Sorts randomly
		items = new TreeMap<>(); // sorts the entries using the keys :item id
	}
	
	
	@Override
	public int addItem(Item i) {
	items.put(i.getItemID(), i);
		return items.size();
	}

	@Override
	public int removeItem(Item i) {
	items.remove(i.getItemID());
		return items.size();
	}

	@Override
	public void printItems() {
	System.out.println("Items in Cart");
	for (Integer itemID: items.keySet()) { // Get all the keys from the map
		Item i = items.get(itemID); // Gets the value from the map using the key
		System.out.println(i);
	}

	}

	@Override
	public double getTotalPrice(double tax, double discountPercentage) {
		// TODO Auto-generated method stub
		return 0;
	}

}
