package com.mastek.training.myshop;

//Using generic type interface, the I would be defined at usage time
public interface ShoppingCart<I> { //The <I> is a generic term as the inputs may be different. Doesn't have to be I but must be letter.
	
	public int addItem(I i); //U case I is a type, the lower case should be the same letter.
	public int removeItem(I i);
	public void printItems();
	public double getTotalPrice(double tax,double discountPercentage); //These are all functions we want to use somewhere else
	

}
