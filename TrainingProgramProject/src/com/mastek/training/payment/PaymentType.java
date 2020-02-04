package com.mastek.training.payment;

public class PaymentType {

	public PaymentType(){}; // This will be the basic constructor
	public PaymentType(long transactionID) {
		this.transactionID=transactionID;
	}
	
	private String transactionDate;
	private Type type;
	private double transactionValue;
	private String customerName;
	private long transactionID;
	private double totalPrice;
	
	
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) { // total price with no fees = transaction value
		this.totalPrice = totalPrice;
	}
	public long getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(long transactionID) {
		this.transactionID = transactionID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public double getTransactionValue() {
		return transactionValue;
	}
	public void setTransactionValue(double transactionValue) {
		this.transactionValue = transactionValue;
	}
	
	
	
	{
		setCustomerName("Example"); // The instance block seems really useful for testing 
		setTransactionDate("12/01/2020");
		setTransactionValue(2.50);
		setTransactionID(92772389);
		
	}
					
	public double calculateTotal() {
		setTotalPrice(getTransactionValue());
		return getTotalPrice(); //What your testing needs to return a value, because this is the function thats tested it needs a value
	}
	
}
