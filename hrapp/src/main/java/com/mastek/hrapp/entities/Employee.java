package com.mastek.hrapp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

@Entity // declares the class as entity, to be managed by JPA
@Table(name="JPA_Employees") // Good practice to have JPA at the start, this will declare the name 
@EntityListeners({EmployeeListener.class}) // This calls the appropriate listener event method
@NamedQueries({
	@NamedQuery(name="Employee.findBySalary", //Declare query name as metodin dao
			query="select e from Employee e where e.salary between :minSalary and :maxSalary") // identify the query to fetch employee objects with properties and parameters (defined as @param)
	,
	@NamedQuery(name="Employee.findByDesignation",
	query="select e from Employee e where e.designation=:designation")
})
public class Employee {



	int empno;
	String name;
	double salary;
	Designation designation;

	Department currentDepartment;


	@ManyToOne //1 employee is associated with one of the many departments
	@JoinColumn(name="fk_department_number")
	@Transient
	public Department getCurrentDepartment() {
		return currentDepartment;
	}

	public void setCurrentDepartment(Department currentDepartment) {
		this.currentDepartment = currentDepartment;
	}


	Set<Project> projectsAssigned = new HashSet<>();


	@ManyToMany(cascade=CascadeType.ALL) // configure many to many
	@JoinTable(name="JPA_PROJECT_ASSIGNMENTS",// provide the join table name
	joinColumns= {@JoinColumn(name="fk_empno")}, // foreign key column for current class
	inverseJoinColumns= {@JoinColumn(name="fk_projectId")}) // foreign key column for collection
	@Transient
	public Set<Project> getProjectsAssigned() {
		return projectsAssigned;
	}

	public void setProjectsAssigned(Set<Project> projectsAssigned) {
		this.projectsAssigned = projectsAssigned;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	@Id // Marking the Property as primary key
	@Column(name="employee_number")// use column to chose the column name, if ya don't do this just be called empno (which is fine)
	@GeneratedValue(strategy=GenerationType.AUTO) // Auto Numbering configuration as per DB
	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}


	@Column(name="employee_name",length=50,nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	//@Transient: this would mean this isn't made in to a field in the database
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}


	@Enumerated(EnumType.STRING)
	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empno;
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
		Employee other = (Employee) obj;
		if (empno != other.empno)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", name=" + name + ", salary=" + salary + ", designation=" + designation
				+ "]";
	}


}
