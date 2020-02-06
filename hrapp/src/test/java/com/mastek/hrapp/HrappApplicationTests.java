package com.mastek.hrapp;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.hrapp.dao.DepartmentJPADAO;
import com.mastek.hrapp.dao.EmployeeJPADAO;
import com.mastek.hrapp.dao.ProjectJPADAO;
import com.mastek.hrapp.entities.Department;
import com.mastek.hrapp.entities.Designation;
import com.mastek.hrapp.entities.Employee;
import com.mastek.hrapp.entities.Project;
import com.mastek.hrapp.services.EmployeeService;

@SpringBootTest // Make sure ya don't leave a line below this 
class HrappApplicationTests {

	@Autowired // Spring will provide the object using the IOC
	EmployeeService empSvc;

	@Autowired
	EmployeeService empSvc1;

	@Autowired
	EmployeeJPADAO empDAO;

	@Autowired 
	DepartmentJPADAO depDao;

	@Autowired
	ProjectJPADAO projDAO;

	@Test
	void testEmployeeServiceExampleMethod() {
		empSvc.exampleMethod();
	}

	//@Test
	void testEmployeeDAOAdd() {
		Employee emp = new Employee();
		emp.setName("Example");
		emp.setSalary(30.00);
		emp.setDesignation(Designation.TESTER);

		//emp=empDAO.save(emp);

		System.out.println(emp);
		assertNotNull(emp);

	}

	@Test
	void testListEmployees(){
		Iterable<Employee> emps = empDAO.findAll();
		assertNotNull(emps,"employee not found");
		for (Employee employee : emps) {
			System.out.println(employee);
		}
	}

	//@Test
	void testDepartmentDAOAdd() {
		Department dep = new Department();
		dep.setName("Example3");
		dep.setLocation("Mahape");


		//dep=depDao.save(dep);

		System.out.println(dep);
		assertNotNull(dep);

	}

	@Test
	void testListDepartments(){
		Iterable<Department> deps = depDao.findAll();
		assertNotNull(deps,"department not found");
		for (Department department : deps) {
			System.out.println(department);
		}
	}

	//@Test
	void testProjectDAOAdd() {
		Project proj = new Project();
		proj.setName("Example1");
		proj.setCustomer_name("MOD");


		//proj=projDAO.save(proj);

		System.out.println(proj);
		assertNotNull(proj);

	}
	
	@Test
	void testListProjects(){
		Iterable<Project> pros = projDAO.findAll();
		assertNotNull(pros,"project not found");
		for (Project project : pros) {
			System.out.println(project);
		}
	}
	
	
	
	@Test
	void testUpdateEmployees() {
		Employee emp = empDAO.findById(2).get();
		int i = 0;
		System.out.println("Employee Fetched: "+emp);
		emp.setSalary(emp.getSalary()+5);
		emp.setName("Updated"+(++i));
		emp = empDAO.save(emp);
		System.out.println("Updated Employee: "+emp);
	}

	
	@Test
	void testDeleteEmployeeByID() {
		//empDAO.deleteById(35); // remember to change this number everytime you do this 
		//empDAO.delete(emp); this deletes by object
	}
	
	@Test
	void testAssignEmployeeToDepartment() {
		Employee emp = empSvc.assignEmployeeToDepartment(2,9);
		assertNotNull(emp.getCurrentDepartment(),"Department not assigned");
	}
	
	
	@Test
	void testAssignExployeeToProject() {
		Employee emp = empSvc.assignEmployeeToProject(2,7);
		assertTrue(emp.getProjectsAssigned().size()>0);
	}
	
	
	
	
}
