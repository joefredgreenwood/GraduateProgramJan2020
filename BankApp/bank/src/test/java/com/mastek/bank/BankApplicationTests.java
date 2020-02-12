package com.mastek.bank;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.bank.dao.AccountDAO;
import com.mastek.bank.dao.CustomersDAO;
import com.mastek.bank.dao.LoanDAO;
import com.mastek.bank.dao.TransactionsDAO;
import com.mastek.bank.dao.TransferDAO;
import com.mastek.bank.entities.Account;
import com.mastek.bank.entities.CarLoan;
import com.mastek.bank.entities.Customers;
import com.mastek.bank.entities.HomeLoan;
import com.mastek.bank.entities.Loan;
import com.mastek.bank.entities.Transaction;
import com.mastek.bank.entities.Transfer;
import com.mastek.bank.services.BankServices;

@SpringBootTest
class BankApplicationTests {

	@Autowired
	AccountDAO accDAO;
	
	@Autowired
	CustomersDAO cusDAO;
	
	@Autowired
	TransactionsDAO tranDAO;
	
	@Autowired
	BankServices banS;
	
	@Autowired
	LoanDAO loanDAO;
	
	@Autowired
	TransferDAO trfDAO;
	
	//@Test
	void testAddTransaction() {
		Transaction tran = new Transaction();
		tran.setTransactionValue(15.00);
		
		tran = tranDAO.save(tran);
		System.out.println(tran);
	}
	
	//@Test
	void testAddCustomers() {
		Customers cus = new Customers();
		cus.setName("Greg");
		cus.setAddress("Ibrox");
		
		cus = cusDAO.save(cus);
		System.out.println(cus);
	}

	//@Test
	void testAddAccount () {
		Account acc = new Account();
		acc.setBalance(9751.00);
		acc.setSortCode("03-03-03");
		
		acc = accDAO.save(acc);
		System.out.println(acc);
	}
	
	//@Test
	void testAssignTransactionAndAccount() {
		Transaction tran = banS.assignAccountAndTransactions(106, 111);
		assertNotNull(tran.getLinkedAccount(),"Not Worked");
	}
	
	//@Test
	void testAssignCustomerToAccount() {
		Customers cus = banS.assignCustomersToAccount(106, 112);
		assertTrue(cus.getAccountAssigned().size()>0,"This hasn't worked");
	}
	
	//@Test
	void testAddCarLoan() {
		CarLoan car = new CarLoan();
		car.setLoanValue(10000);
		car.setDurationNoOfMonths(36);
		car.setCarYear(2012);
		car.setCarModel("Nissan");
		
		car = loanDAO.save(car);
		System.out.println(car);
				
	}
	
	//@Test
	void testAddHouseLoan() {
		HomeLoan home = new HomeLoan();
		home.setDurationNoOfMonths(360);
		home.setLoanValue(200000);
		home.setHomeType("Bungalow");
		home.setHouseAge(60);
		
		home = loanDAO.save(home);
		System.out.println(home);
	}
	
	//@Test
	void testAddLoan() {
		Loan loan = new Loan();
		loan.setDurationNoOfMonths(15);
		loan.setLoanValue(200.00);
		
		loan = loanDAO.save(loan);
		System.out.println(loan);
	}
	
	//@Test
	void testAddTransfer() {
		Transfer trf = new Transfer();
		trf.setId(2);
		trf.setAmmount(10000.00);
		trf.setFromAccount("Greg");
		trf.setToAccount("me");
		trf.setDescription("Eating Challenge");
		
		trf = trfDAO.save(trf);
		System.out.println(trf);
	}
	
	@Test
	void testAssignTransactionAndTransfer() {
		Transfer trf = banS.assignnTransferToTransaction(2, 105);
		for (Transaction trsf: trf.getTransactionLink()) {
			System.out.println(trsf);
		}
	}
	
}
