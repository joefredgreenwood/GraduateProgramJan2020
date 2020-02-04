package com.mastek.training.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import com.mastek.training.myshop.Item;
import com.mastek.training.myshop.ListShoppingCart;
import com.mastek.training.myshop.MapShoppingCart;
import com.mastek.training.myshop.SetShoppingCart;
import com.mastek.training.myshop.ShoppingCart;

class ShoppingCartAppTests {
ShoppingCart<Item> sc; //The <Item> takes the generic <I> from the interface and shows what it actually is


@BeforeEach
	void setUp() throws Exception {
		//sc = new ListShoppingCart();	// This sets up a new shopping list - This is the LIst example
		//sc = new SetShoppingCart(); //This is a set example (doesn't accept duplicates.
	sc = new MapShoppingCart(); // Map Example
	}

	@AfterEach
	void tearDown() throws Exception {
		sc = null;		
	}




	@Test
	void testShoppingCartAddItem() {
		int size = sc.addItem(new Item(1,"Name",233.0,1));
		assertEquals(1,size,"Item Added");
		
	}

	@Test
	void testShoppingCartPrintItems() {
		sc.addItem(new Item(4,"Item 1",233.0,1));
		sc.addItem(new Item(2,"Item 2",1233.0,1));
		sc.addItem(new Item(3,"Item 3",2233.0,1));
		sc.addItem(new Item(3,"Item 3",2233.0,1));

		sc.printItems();

	}
	
	@Test
	void testShoppingCartRemoveItems() {
		sc.addItem(new Item(1,"Item 1",233.0,1));
		sc.addItem(new Item(2,"Item 2",1233.0,1));
		sc.addItem(new Item(3,"Item 3",2233.0,1));

		sc.printItems();
		int size = sc.removeItem(new Item(2));
		assertEquals(2,size,"Item Removed");
		sc.printItems();

	}
	
		

}
