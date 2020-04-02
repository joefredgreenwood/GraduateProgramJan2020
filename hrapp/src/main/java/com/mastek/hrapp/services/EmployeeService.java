package com.mastek.hrapp.services;

import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.hrapp.apis.DepartmentAPI;
import com.mastek.hrapp.apis.EmployeeAPI;
import com.mastek.hrapp.apis.ProjectAPI;
import com.mastek.hrapp.dao.DepartmentJPADAO;
import com.mastek.hrapp.dao.EmployeeJPADAO;
import com.mastek.hrapp.dao.JobPositionsDAO;
import com.mastek.hrapp.dao.ProjectJPADAO;
import com.mastek.hrapp.entities.Department;
import com.mastek.hrapp.entities.Employee;
import com.mastek.hrapp.entities.JobPositions;
import com.mastek.hrapp.entities.Project;

@Component // Marks the class as bean to be created
@Scope("singleton") // This means it creates a new object each time it is called
public class EmployeeService implements EmployeeAPI,ProjectAPI,DepartmentAPI{

	String exampleProperty;
	
	@Autowired
	EmployeeJPADAO empDAO;
	
	@Autowired
	DepartmentJPADAO depDAO;
	
	@Autowired
	ProjectJPADAO projDAO;
	
	@Autowired
	JobPositionsDAO jobDAO;
	
	
	public EmployeeService() {
		System.out.println("Employee Service Created");
	}
	
	@PostConstruct // initialize the method of the class
	public void initializeService() {
		System.out.println("Employee Service initialised");
	}
	
	
	@PreDestroy
	public void terminateService() {
		System.out.println("Employee Service Terminated");
	}
	
	
	public void exampleMethod() {
		System.out.println("connect to "+getExampleProperty()+" for business data");
	}
	
	
	
	public String getExampleProperty() { // Getter
		return exampleProperty;
	}


	@Value("Spring Example Data Source") // initialize the property with the simple value //Setter
	public void setExampleProperty(String exampleProperty) {
		System.out.println("Example Property Set: "+exampleProperty);
		this.exampleProperty = exampleProperty;
	}

	@Transactional // this will keep the session open until the method returns the value.
	public Employee assignEmployeeToDepartment(int empno, int depno) {
		Employee emp = empDAO.findById(empno).get();
		Department dep = depDAO.findById(depno).get();
		
		//assign the association between employee and department
		emp.setCurrentDepartment(dep);
		dep.getTeam().add(emp);
		
		empDAO.save(emp);
		depDAO.save(dep);
				
		return emp;
	}

	@Transactional
	public Employee assignEmployeeToProject(int empno, int projectId) {
		Employee emp = empDAO.findById(empno).get();
		Project proj = projDAO.findById(projectId).get();
		
		emp.getProjectsAssigned().add(proj);
		empDAO.save(emp);
		
		return emp;
		
	}

@Transactional
public JobPositions applyForPosition(int jobId,int empno) {
	JobPositions job = jobDAO.findById(jobId).get();
	Employee emp = empDAO.findById(empno).get();
	
	job.getApplicants().add(emp);
	
	job=jobDAO.save(job);
	return job;
}

@Override
public Iterable<Employee> listAllEmployees() {
	System.out.println("Listing all employees");
	return empDAO.findAll();
}

@Override
public Employee findByEmpno(int empno) {
	return empDAO.findById(empno).get();
}

@Override
public Employee registerNewEmployee(Employee newEmployee) {
	newEmployee = empDAO.save(newEmployee);
	return newEmployee;
}

@Override
public Iterable<Department> listAllDepartments() {
	return depDAO.findAll();
	
}

@Override
public Department findByDepno(int depno) {
	return depDAO.findById(depno).get();
}

@Override
public Department registerNewDepartment(Department newDepartment) {
	newDepartment = depDAO.save(newDepartment);
	return newDepartment;
}

@Override
public Iterable<Project> listAllProjects() {
	return projDAO.findAll();
}

@Override
public Project findByProjectId(int projectId) {
	return projDAO.findById(projectId).get();
}

@Override
public Project registerNewProject(Project newProject) {
newProject = projDAO.save(newProject);
	return newProject;
}
@Override
@Transactional //to fetch all collections
public Set<Project> getEmployeeProjects(int empno) {
    Employee currentEmp = empDAO.findById(empno).get();
    int count = currentEmp.getProjectsAssigned().size();
    System.out.println(count +" Projects found");
    
    Set<Project> projects = currentEmp.getProjectsAssigned();
    return projects;
}



@Override
@Transactional
public Project registerProjectForEmployee(int empno, Project newProject) {
    newProject = projDAO.save(newProject);
    assignEmployeeToProject(empno, newProject.getProjectId());
    return newProject;
}
	
}
