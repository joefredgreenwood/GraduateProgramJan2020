package com.mastek.hrapp.apis;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mastek.hrapp.entities.Department;


@Path("/hrapp/")
public interface DepartmentAPI {

	
	@GET
	@Path("/departments/list")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Iterable<Department> listAllDepartments();
	
	@GET
	@Path("/departments/find/{depno}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Department findByDepno(@PathParam("depno") int depno);
	
	
	@POST // http method post to to send data in requests
	@Path("/departments/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Department registerNewDepartment(@BeanParam Department newDepartment);
}
