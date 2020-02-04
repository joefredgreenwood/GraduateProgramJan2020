package com.mastek.training.hrapp; //This location is the file location

import java.io.Serializable;
import java.io.StringReader;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;

import org.bson.Document;
import org.glassfish.json.JsonParserImpl;

public class Employee implements Serializable{
//We are using serializeable as marker interface to manage serialization using input/output streams
	private int empno;
	private String name;
	private double unitSalary;
	private Designations designation;
	private transient Grades grade; //transient denoted the serializer to skip this field while storing using binary files


	public static final int MAX_PAID_DAYS=90;
	public static final int MIN_PAID_DAYS=10;
	public static final int MAX_DAY_RATE=999999;
	public static final int DEFAULT_ZERO=0;
	public static final int MIN_DAY_RATE=10;
	public static final int MAX_EMPNO=999999;

	//blocks
	//static block - executes at class loading time
	static {
		System.out.println("Employee Static Block Called");
	}

	//INstance Block - executed before the constructor is called for any object of the class
	{
		setEmpno(999);
		setName("Example");
		setUnitSalary(MIN_DAY_RATE);
		setDesignation(Designations.OTHER);
		System.out.println("Employee Instance Block Called");
	}


	//default constructor: A constructor without any arguments
	// Constructor helps a developer to create a usable object for simulations

	public Employee() { //Method Constructor Overloading, same name but different parameters. This is polymorphism!!
		System.out.println("Employee Default Constructor Called");
		System.out.println("Eno:"+getEmpno()+", name:"+getName()+", Unit Salary:"+getUnitSalary()+", Designation:"+getDesignation());
	}

	public Employee(int empno) {//This constructor means you have to put in the empno
		this.setEmpno(empno);
		System.out.println("Employee Default Constructor Called with Empno: "+empno);
		System.out.println("Eno:"+getEmpno()+", name:"+getName()+", Unit Salary:"+getUnitSalary()+", Designation:"+getDesignation());
	}

	public Employee (int empno,String name,double unitSalary, Designations designations) {//This constructor means you put in everything
		this.setEmpno(empno);
		this.setName(name);
		this.setUnitSalary(unitSalary);
		this.setDesignation(designations);
		System.out.println("Employee Master Constructor Called ");
		System.out.println("Eno:"+getEmpno()+", name:"+getName()+", Unit Salary:"+getUnitSalary()+", Designation:"+getDesignation());
	}

	//This is an internal method called by Garbage Collection before deleting the object. You can notify to collect the garbage 
	//using System.gc();
	public void finalize() {
		setEmpno(0);
		setName(null);
		setUnitSalary(0);
		setDesignation(null);
		setGrade(null);
		System.out.println("Employee Object Finalised");
	}

	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		if(empno>DEFAULT_ZERO && empno<MAX_EMPNO) {
			this.empno = empno;
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getUnitSalary() {
		return unitSalary;
	}
	public void setUnitSalary(double unitSalary) {
		if(unitSalary>DEFAULT_ZERO && unitSalary<MAX_DAY_RATE) {
			this.unitSalary = unitSalary;}
	}
	public Designations getDesignation() {
		return designation;
	}
	public void setDesignation(Designations designation) {
		this.designation = designation;
	}
	public Grades getGrade() {
		return grade;
	}
	public void setGrade(Grades grade) {
		this.grade = grade;
	}




	public double getNetSalary(int noOfDays) throws Exception {
		if(noOfDays<DEFAULT_ZERO) {
			//Raise an exception specific to business conditions
			throw new Exception("Invalid Input for Days: "+noOfDays);
			//throw new RuntimeException("INVALID INPUT");
		}
		if(noOfDays<DEFAULT_ZERO || noOfDays>=MAX_PAID_DAYS) {
			noOfDays=DEFAULT_ZERO;
		}
		return getUnitSalary()*noOfDays;
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", name=" + name + ", unitSalary=" + unitSalary + ", designation="
				+ designation + ", grade=" + grade + "]";
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

	public static String getJSONString(Employee emp) {
		JsonObjectBuilder jsonBuilder = new JsonObjectBuilder();
		jsonBuilder.add("empno", emp.getEmpno()); // These have to be the same as parse
		jsonBuilder.add("name", emp.getName());
		jsonBuilder.add("day-salary", emp.getUnitSalary());
		jsonBuilder.add("designation", emp.getDesignation().toString());
		jsonBuilder.add("grade", emp.getGrade().toString());
		
		String jsonEmp = jsonBuilder.build().toString();
		System.out.println(jsonEmp);
		return jsonEmp;
		
	}
	
	public static Employee parseJSONString(String empJSON) {
		JsonReader reader = new JsonReader(new StringReader(empJSON));
		JsonObject empJSONObject = reader.readObject();
		
		Employee emp = new Employee();
		emp.setEmpno(empJSONObject.getIntValue("empno")); // These values have to be the same as read
		emp.setName(empJSONObject.getStringValue("name"));
		emp.setUnitSalary(empJSONObject.getIntValue("day-salary"));
		emp.setGrade(Grades.valueOf(empJSONObject.getStringValue("grade")));
		emp.setDesignation(Designations.valueOf(empJSONObject.getStringValue("designation")));
		
		System.out.println("From JSon: "+empJSON);
		System.out.println("To Emp: "+emp);
		
		reader.close();
		return emp;
	}
	
	public static Document getEmployeeMongoDocument(Employee emp) {
		Document docEmp = new Document();
		docEmp.put("empno", emp.getEmpno());
		docEmp.put("name", emp.getName());
		docEmp.put("unit_salary", emp.getUnitSalary());
		docEmp.put("grade", emp.getGrade().toString());
		docEmp.put("designation", emp.getDesignation().toString());
		return docEmp;
	}
	
	public static Employee getEmployeeFromMOngoDocument(Document empDoc) {
		Employee emp = new Employee();
		try {
		emp.setEmpno(empDoc.getInteger("empno"));
		emp.setName(empDoc.getString("name"));
		emp.setUnitSalary(empDoc.getDouble("unit_salary"));
		emp.setGrade(Grades.valueOf(empDoc.getString("grade")));
		emp.setDesignation(Designations.valueOf(empDoc.getString("designation")));
		}
		catch(Exception ex) {
			ex.printStackTrace();
			emp=null;
		}
		return emp;
	}
	
	


}
