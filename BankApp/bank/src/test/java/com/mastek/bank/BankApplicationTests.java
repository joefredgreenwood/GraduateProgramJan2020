package com.mastek.bank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.bank.dao.AccountDAO;
import com.mastek.bank.dao.CustomersDAO;
import com.mastek.bank.dao.TransactionsDAO;
import com.mastek.bank.entities.Customers;
import com.mastek.bank.entities.Transaction;

@SpringBootTest
class BankApplicationTests {

	@Autowired
	AccountDAO accDAO;
	
	@Autowired
	CustomersDAO cusDAO;
	
	@Autowired
	TransactionsDAO tranDAO;
	
	@Test
	void testAddTransaction() {
		Transaction tran = new Transaction();
		tran.setTransactionValue(10.00);
		
		tran = tranDAO.save(tran);
		System.out.println(tran);
	}
	
	@Test
	void testAddCustomers() {
		Customers cus = new Customers();
		cus.setName("Joe");
		cus.setAddress("Example");
		
		cus = cusDAO.save(cus);
		System.out.println(cus);
	}

}
