package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mastek.training.payment.CreditCard;
import com.mastek.training.payment.PaymentType;
import com.mastek.training.payment.Paypal;

class PaymentTypeTest {

	PaymentType c2;
	CreditCard c1;
	Paypal c3;

	@BeforeEach
	public void setupPaymentTestOne() { // think this might have to be first line of before each
		c1 = new CreditCard();	
		c2 = new PaymentType();
		c3 = new Paypal();
		System.out.println("New Test");
	}

	@Test
	void testCreditCard(){
		//c2.calculateTotal();
		assertEquals(3.0,c1.calculateTotal(), "FAILED_CC"); //Testing requires a returned value, the 3 has to be returned somewhere
		System.out.println(c1.getTotalPrice());
	}
	@Test
	void testPaypal() {
		System.out.println(c3.getEmailAddress()+" Name - "+c3.getCustomerName());
	}
}


