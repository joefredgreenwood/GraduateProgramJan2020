package com.mastek.hrapp.apis;

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

import com.mastek.hrapp.entities.Employee;
import com.mastek.hrapp.entities.Project;


@Path("/hrapp/") // identifies the url pattern to access the current API interface
public interface EmployeeAPI {
	
	
	// http://localhost:7777/hrapp/employees/list
	@GET
	@Path("/employees/list")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) // formats which the methods support - one you write first is default
	public Iterable<Employee> listAllEmployees();
	
	
	@GET
	@Path("/employees/find/{empno}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Employee findByEmpno(@PathParam("empno") int empno);
	
	
	@POST // http method post to to send data in requests
	@Path("/employees/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Employee registerNewEmployee(@BeanParam Employee newEmployee);
	
	
    @GET
    @Path("/employees/projects/{empno}")
    @Produces({MediaType.APPLICATION_JSON})
    public Set<Project> getEmployeeProjects(@PathParam("empno") int empno);
    
    @POST
    @Path("/employees/projects/register")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Project registerProjectForEmployee(
            @FormParam("empno") int empno,
            @BeanParam Project newProject);



}
