package com.mastek.hrapp;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.hrapp.dao.DepartmentJPADAO;
import com.mastek.hrapp.dao.EmployeeJPADAO;
import com.mastek.hrapp.dao.JobPositionsDAO;
import com.mastek.hrapp.dao.PaymentJPADAO;
import com.mastek.hrapp.dao.ProjectJPADAO;
import com.mastek.hrapp.entities.CardPayment;
import com.mastek.hrapp.entities.ChequePayment;
import com.mastek.hrapp.entities.Department;
import com.mastek.hrapp.entities.Designation;
import com.mastek.hrapp.entities.Employee;
import com.mastek.hrapp.entities.JobPositions;
import com.mastek.hrapp.entities.Payment;
import com.mastek.hrapp.entities.Project;
import com.mastek.hrapp.services.EmployeeService;

import net.bytebuddy.agent.ByteBuddyAgent.AttachmentProvider.ForEmulatedAttachment;

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

	@Autowired
	PaymentJPADAO paymentDAO;
	
	@Autowired
	JobPositionsDAO jobDAO;
	
	@Test
	void testAddJobPosition() {
		JobPositions job = new JobPositions();
		job.setJobId(162);
		job.setClientName("Example");
		job.setLocation("Leeds");
		job.setNumberOfPositions(2);
		
		job=jobDAO.save(job);
		assertNotNull(job,"failed");
	}
//
//	@Test
//	void testListPositions() {
//		
//		for (JobPositions job : jobDAO.findAll()) {
//			System.out.println(job);
//		}
//	}
//
//	
//
//	@Test
//	void testFindBySalary() {
//		double minS=20.0;
//		double maxS=5000.0;
//		Iterable<Employee> emps = empDAO.findBySalary(minS,maxS);
//		for (Employee employee : emps) {
//			System.out.println(employee);
//		}
//	}
//
//	@Test
//	void testFindEmployeeByDesignation() {
//		Iterable<Employee> emps = empDAO.findByDesignation(Designation.ARCHITECT);
//		for (Employee employee : emps) {
//			System.out.println(employee);
//		}
//	}
//
//
//
//	@Test
//	void testCashPaymentAdd() {
//		Payment cashP = new Payment();
//		cashP.setAmount(100);
//
//		cashP = paymentDAO.save(cashP);
//		System.out.println(cashP);
//		assertNotNull(cashP,"Cash Payment Not Saved");
//	}
//
//	@Test
//	void testAddCardPayment() {
//		CardPayment cardP = new CardPayment();
//		cardP.setAmount(50);
//		cardP.setCardNumber(2937927927l);
//		cardP.setCardService("VISA");
//
//		cardP = paymentDAO.save(cardP);
//		System.out.println(cardP);
//		assertNotNull(cardP,"Card not worked");
//
//	}
//
//	@Test
//	void testChequePayment() {
//		ChequePayment chequeP = new ChequePayment();
//		chequeP.setAmount(60);
//		chequeP.setChequeNumber(2637);
//		chequeP.setBankName("Natwest");
//
//		chequeP = paymentDAO.save(chequeP);
//		System.out.println(chequeP);
//		assertNotNull(chequeP,"Cheque failed");
//	}
//
//	@Test
//	void testEmployeeServiceExampleMethod() {
//		empSvc.exampleMethod();
//	}
//
//	//@Test
//	void testEmployeeDAOAdd() {
//		Employee emp = new Employee();
//		emp.setName("Example");
//		emp.setSalary(30.00);
//		emp.setDesignation(Designation.TESTER);
//
//		//emp=empDAO.save(emp);
//
//		System.out.println(emp);
//		assertNotNull(emp);
//
//	}
//
//	@Test
//	void testListEmployees(){
//		Iterable<Employee> emps = empDAO.findAll();
//		assertNotNull(emps,"employee not found");
//		for (Employee employee : emps) {
//			System.out.println(employee);
//		}
//	}
//
//	//@Test
//	void testDepartmentDAOAdd() {
//		Department dep = new Department();
//		dep.setName("Example3");
//		dep.setLocation("Mahape");
//
//
//		//dep=depDao.save(dep);
//
//		System.out.println(dep);
//		assertNotNull(dep);
//
//	}
//
//	@Test
//	void testListDepartments(){
//		Iterable<Department> deps = depDao.findAll();
//		assertNotNull(deps,"department not found");
//		for (Department department : deps) {
//			System.out.println(department);
//		}
//	}
//
//	//@Test
//	void testProjectDAOAdd() {
//		Project proj = new Project();
//		proj.setName("Example1");
//		proj.setCustomer_name("MOD");
//
//
//		//proj=projDAO.save(proj);
//
//		System.out.println(proj);
//		assertNotNull(proj);
//
//	}
//
//	@Test
//	void testListProjects(){
//		Iterable<Project> pros = projDAO.findAll();
//		assertNotNull(pros,"project not found");
//		for (Project project : pros) {
//			System.out.println(project);
//		}
//	}
//
//
//
//	@Test
//	void testUpdateEmployees() {
//		Employee emp = empDAO.findById(2).get();
//		System.out.println("Employee Fetched: "+emp);
//		emp.setSalary(emp.getSalary()+5);
//		emp.setName("Updated");
//		emp = empDAO.save(emp);
//		System.out.println("Updated Employee: "+emp);
//	}
//
//
//	@Test
//	void testDeleteEmployeeByID() {
//		//empDAO.deleteById(35); // remember to change this number everytime you do this 
//		//empDAO.delete(emp); this deletes by object
//	}
//
//	@Test
//	void testAssignEmployeeToDepartment() {
//		Employee emp = empSvc.assignEmployeeToDepartment(2,9);
//		assertNotNull(emp.getCurrentDepartment(),"Department not assigned");
//	}


//	@Test
//	void testAssignExployeeToProject() {
//		Employee emp = empSvc.assignEmployeeToProject(2,7);
//		empSvc.assignEmployeeToProject(2, 13);
//		assertTrue(emp.getProjectsAssigned().size()>0);
//	}


//	@Test
//	void testAssignApplyForJobPositions() {
//		JobPositions job = empSvc.applyForPosition(162, 20);
//		assertNotNull(job,"Not worked");
//		for (Employee applicant : job.getApplicants()) {
//			System.out.println(applicant);
//		}
//	}
//	
//	@Test
//	void testMultiple() {
//		Employee emp = new Employee();
//		emp.setProjectsAssigned(projectsAssigned);
//	}






}
