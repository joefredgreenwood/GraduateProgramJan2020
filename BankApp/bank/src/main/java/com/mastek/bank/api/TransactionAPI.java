package com.mastek.bank.api;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mastek.bank.entities.Customers;
import com.mastek.bank.entities.Transaction;

@Path("/bankapp/")
public interface TransactionAPI {
	
	@GET
	@Path("/transactions/list")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) // formats which the methods support - one you write first is default
	public Iterable<Transaction> listAllTransactions();
	
	@GET
	@Path("/transactions/find/{transactionId}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Transaction findByTransactionId(@PathParam("transactionId") int transactionId);
	
	@POST // http method post to to send data in requests
	@Path("/transactions/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Transaction registerNewTransaction(@BeanParam Transaction newTransaction);


}
