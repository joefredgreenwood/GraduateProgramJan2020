package com.mastek.training.payment;

public class Paypal extends PaymentType {
	
	public Paypal() {
		super();
	}
	
	private String emailAddress;
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	{
		setEmailAddress("example@email.com");
	}
	

}
