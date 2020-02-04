package com.mastek.training.tests;


import static org.junit.jupiter.api.Assertions.*; // This is a key thing to import, imports all assertions

import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mastek.training.hrapp.Designations;
import com.mastek.training.hrapp.Employee;
import com.mastek.training.hrapp.Grades;
import com.mastek.training.hrapp.dao.DataAccessObject;
import com.mastek.training.hrapp.dao.EmployeeBinaryFileDAO;
import com.mastek.training.hrapp.dao.EmployeeJDBSDAO;
import com.mastek.training.hrapp.dao.EmployeeJSonFileDAO;
import com.mastek.training.hrapp.dao.EmployeeMongoDAO;

class EmployeeDAOTests {

	DataAccessObject<Employee> empDAO;
	
	
	@BeforeEach
	void setUp() throws Exception {
	//empDAO = new EmployeeBinaryFileDAO("empdata.dat");	//Binary File Example
	//empDAO = new EmployeeJSonFileDAO("empdata.json");		//JSon Example
	//empDAO = new EmployeeJDBSDAO();						//SQL Example
	empDAO = new EmployeeMongoDAO();
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	

	@Test
	void testAddEmployeeData() {
		Employee newEmp = new Employee();
		newEmp.setEmpno(22);
		newEmp.setName("Example");
		newEmp.setDesignation(Designations.ARCHITECT);
		newEmp.setGrade(Grades.G4);
		newEmp.setUnitSalary(200);
		
		/*String jsonOBJ = Employee.getJSONString(newEmp);
		System.out.println(jsonOBJ);
		Employee exemp = Employee.parseJSONString(jsonOBJ);
		System.out.println(exemp);*/
		
		newEmp = empDAO.add(newEmp); // returns the object if saved successfully
		assertNotNull(newEmp,"Employee not added");
		
		Employee fetchEmp = empDAO.find(22);
		assertNotNull(fetchEmp,"Employee not Found");
	}

	@Test
	void testListAllEmployees() {
		Collection<Employee> emps = empDAO.listAll();
		for (Employee employee:emps) {
			System.out.println(employee);
		}
	}
	
	@Test
	void testRemoveEmployee() {
		Employee newEmp = new Employee();
		newEmp.setEmpno(1274);
		newEmp.setName("Remove Example");
		newEmp.setDesignation(Designations.ARCHITECT);
		newEmp.setGrade(Grades.G4);
		newEmp.setUnitSalary(200);
		
		newEmp = empDAO.add(newEmp); // returns the object if saved successfully
		assertNotNull(newEmp,"Employee not added");
		
		Employee removedEmp = empDAO.remove(1274);
		assertNotNull(removedEmp,"Employee Not removed");
		
		Employee checkRemovedEmp = empDAO.find(1274);
		assertNull(checkRemovedEmp,"Employee Not removed"); //Checking that the removed value is no longer there.
		
	}
	
}
