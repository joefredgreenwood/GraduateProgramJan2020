package com.mastek.bank.api;

import java.util.Set;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mastek.bank.entities.Account;
import com.mastek.bank.entities.Customers;




@Path("/bankapp/")
public interface CustomerAPI {

	@GET
	@Path("/customers/list")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) // formats which the methods support - one you write first is default
	public Iterable<Customers> listAllEmployees();

	@GET
	@Path("/customers/find/{custNo}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Customers findByCustNo(@PathParam("custNo") int custNo);

	@POST // http method post to to send data in requests
	@Path("/customers/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Customers registerNewCustomer(@BeanParam Customers newCustomer);

	@GET
	@Path("/customers/accounts/{custNo}")
	@Produces({MediaType.APPLICATION_JSON})
	public Set<Account> getCustomerAcconts(@PathParam("custNo") int custNo);

	@POST
	@Path("/customers/accounts/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Account registerAccountForCustomer(
			@FormParam("custNo") int custNo,
			@BeanParam Account newAccount);


}
