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
import com.mastek.hrapp.entities.Project;

@Path("/hrapp/")
public interface ProjectAPI {

	
		@GET
		@Path("/projects/list")
		@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		public Iterable<Project> listAllProjects();
		
		@GET
		@Path("/projects/find/{projectId}")
		@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		public Project findByProjectId(@PathParam("projectId") int projectId);
		
		
		@POST // http method post to to send data in requests
		@Path("/projects/register")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.APPLICATION_JSON)
		public Project registerNewProject(@BeanParam Project newProject);
		
		
}
