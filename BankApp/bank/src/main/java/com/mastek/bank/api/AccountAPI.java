package com.mastek.bank.api;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mastek.bank.entities.Account;
import com.mastek.bank.entities.Transaction;

@Path("/bankapp/")
public interface AccountAPI {

	@GET
	@Path("/accounts/list")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) // formats which the methods support - one you write first is default
	public Iterable<Account> listAllAccounts();
	
	@GET
	@Path("/accounts/find/{accountNumber}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Account findByAccountId(@PathParam("accountNumber") int accountNumber);
	
	@POST // http method post to to send data in requests
	@Path("/accounts/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Account registerNewAccount(@BeanParam Account newAccount);
}
