package com.mastek.training.payment;

public class CreditCard extends PaymentType {
	
	public CreditCard() {
		super();
	}
	
	private double creditCardFee;

	public double getCreditCardFee() {
		return creditCardFee;
	}

	public void setCreditCardFee(double creditCardFee) {
		this.creditCardFee = creditCardFee;
	}
	
	{
		setCreditCardFee(0.50);
	}
	
	
	
	@Override
	public double calculateTotal() {
		setTotalPrice(0.5+getTransactionValue());
		return getTotalPrice();
		
	}
	
	

}
