package com.mastek.hrapp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity
@Table(name="JPA_Projects")
public class Project {
	
	
	private int projectId;
	
	@FormParam("name")
	private String name;
	
	@FormParam("customerName")
	private String customerName;
	
	Set<Employee> projectTeam = new HashSet<>();
	
	@ManyToMany(mappedBy="projectsAssigned")
	@XmlTransient
	public Set<Employee> getProjectTeam() {
		return projectTeam;
	}

	public void setProjectTeam(Set<Employee> projectTeam) {
		this.projectTeam = projectTeam;
	}

	public Project() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + projectId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (projectId != other.projectId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", name=" + name + ", customer_name=" + customerName + "]";
	}
	

}
