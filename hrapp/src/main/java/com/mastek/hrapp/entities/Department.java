package com.mastek.hrapp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity
@Table(name="jpa_departments")
public class Department {



	private int depno;
	
	@FormParam("name")
	private String name;
	
	@FormParam("location")
	private String location;
	

	Set<Employee> team = new HashSet<>();
	
	//Associates the many entity using collection with cascade enabled
	@OneToMany(mappedBy="currentDepartment", cascade=CascadeType.ALL)	
	@XmlTransient
	public Set<Employee> getTeam() {
		return team;
	}
	
	public void setTeam(Set<Employee> team) {
		this.team = team;
	}


	public Department() {
	// TODO Auto-generated constructor stub
	}


	@Id
	@Column(name="department_number")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getDepno() {
		return depno;
	}
	
	public void setDepno(int depno) {
		this.depno = depno;
	}
	
	@Column(length=50)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + depno;
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
		Department other = (Department) obj;
		if (depno != other.depno)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Department [depno=" + depno + ", name=" + name + ", location=" + location + "]";
	}
	
	
}
