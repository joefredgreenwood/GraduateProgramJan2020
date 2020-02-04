package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.After; // because test isn't linked to the employee through hierarchy it needs to be imported. This code is free as it is org
import org.junit.Before; // Things like math can be imported so you don't have to put .math. everytime you want to use pi etc...
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mastek.training.hrapp.Announcement;
import com.mastek.training.hrapp.Designations;
import com.mastek.training.hrapp.EmailAnnouncement;
import com.mastek.training.hrapp.Employee;
import com.mastek.training.hrapp.Grades;
import com.mastek.training.hrapp.SMSAnnouncement;
import com.mastek.training.hrapp.SalesEmployee;
import com.mastek.training.pack1.Circle;
import com.mastek.training.pack1.Rectangle;
import com.mastek.training.pack1.Shape;


class HRApplicationTests {

	Employee ex1;
	
	@BeforeEach
	public void setupEmpTestCase() {
		System.out.println("Before Test Case");
		//Employee.DEFAULT_ZERO // <class_Name>.<static_Member>
		ex1 = new Employee();
		ex1.setEmpno(2797);
		ex1.setName("example");
		ex1.setDesignation(Designations.MANAGER);
		ex1.setUnitSalary(292);
		ex1.setGrade(Grades.G5);
		
		Employee ex2 = new Employee(121);
		
		Employee ex3 = new Employee(22, "Joe", 3, Designations.ARCHITECT);
		
		ex2=null;
				
		ex3=null;
		System.gc();//notify system to collect garbage
		//ex2.getEmpno() will throw NullPointerException
	}
	@AfterEach
	public void tearDownEmpTestCases() {
		System.out.println("After Test Case");	

	}



	@Test
	void testCreateAndPrintExampleEmployeeObject() {
		System.out.println("Test Case Create");
		/*Employee ex1 = new Employee();
		ex1.setEmpno(2797);
		ex1.setName("example");
		ex1.setDesignation(Designations.MANAGER);
		ex1.setUnitSalary(292);
		ex1.setGrade(Grades.G5);*/
		System.out.println(
				"Number: "+ex1.getEmpno()+ 
				"\nName: "+ex1.getName()+ 
				"\nDay Salary: "+ex1.getUnitSalary()+ 
				"\nDesignation: "+ex1.getDesignation()+ 
				"\nGrade: "+ex1.getGrade());

	}



	@Test
	void testCreateAndComputeSalaryEmployeeObject() {
		System.out.println("Test 2");
		/*Employee ex1 = new Employee();
		ex1.setEmpno(2797);
		ex1.setName("example");
		ex1.setDesignation(Designations.MANAGER);
		ex1.setUnitSalary(300);
		ex1.setGrade(Grades.G5);*/

		try {
			assertEquals(0.0,ex1.getNetSalary(-30),"Invalid Net Salary Computation");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



@Test
void testSalesEmployeeObjectUsage () {
	SalesEmployee saleEx1 = new SalesEmployee();
	saleEx1.setEmpno(66);
	saleEx1.setName("Jake");
	saleEx1.setUnitSalary(100);
	saleEx1.setDesignation(Designations.DEVELOPER);
	saleEx1.setGrade(Grades.CX);
	saleEx1.setCommision(0.8);
	saleEx1.setTarget(1000000000);

try {
	assertEquals(1620,saleEx1.getNetSalary(9),"Invalid Salary Calculated");
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

}

@Test
void testObjectFeaturesOnEmployee() {
	System.out.println("<=======Object Features========>");
	System.out.println(ex1.toString());
	System.out.println("Hashcode: "+ex1.hashCode());
	System.out.println("<=========Object Features End=======>");
}
@Test
void testSendAnnouncementToEmployees() {
	//Announcement exAnnouncement = new Announcement(); // Abstract classes can't use the word new to create a new object
	//To use an abstract method you need to first override all abstract methods.
	Announcement exSMS = new SMSAnnouncement();
	exSMS.setFrom("UK Group");
	exSMS.setForGroup("Mastekeers in Glasgow");
	exSMS.setSubject("Bad weather at Glasgow");
	exSMS.setContentText("Work from Home, bad weather");
	
			
	Announcement exEmail = new EmailAnnouncement();
	exEmail.setFrom("Leadership Team");
	exEmail.setForGroup("Mastekeers");
	exEmail.setSubject("QMeet Jan 2020");
	exEmail.setContentText("You are invited to QMeet via Webex");
	
	
	if (exSMS instanceof SMSAnnouncement) {
		System.out.println("Connect to Telecom Service");
		exSMS.sendAnnouncement(); // These will automatically connect to the correct classes.	
	}

	
	
	if (exEmail instanceof EmailAnnouncement) {
		System.out.println("Connect to Email Service");
		exEmail.sendAnnouncement();
	}
	
	assertTrue(exSMS instanceof SMSAnnouncement,"Invalid Announcement Implementation");
	assertTrue(exEmail instanceof EmailAnnouncement,"Invalid Announcement Implementation");
}

@Test
void testShapeExample () {
	Rectangle rect = new Rectangle();
	rect.setLength(10);
	rect.setWidth(20);
	
	Circle circle = new Circle();
	circle.setRadius(20);
	
	Shape shRect = rect;
	Shape shCircle = circle;
	
	System.out.println("Rectangle Area: "+shRect.getArea());
	System.out.println("Rectangle Perimeter: "+shRect.getPerimeter());
	
	System.out.println("Circle Area: "+shCircle.getArea());
	System.out.println("Circle Perimeter: "+shCircle.getPerimeter());
			
	assertTrue(rect instanceof Shape,"invalid type of shape");
	assertTrue(circle instanceof Shape,"Invalid type of shape"); // This just does a test to make sure its working but wont show owt
	
	
}








}