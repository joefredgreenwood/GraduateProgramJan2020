package com.mastek.training.hrapp;
//Each class specifies their base/parent class nameusing extends. If the class does not have extends key word
//it is automatically inheriting java.lang.Object
public class SalesEmployee extends Employee {

	long target;
	double commision;
	
	public SalesEmployee() {
		//Use "super" to call all the base class constructors from the child derived class.
		//IT MUST BE THE FIRST LINE
		super(777,"Sales Example",99,Designations.MANAGER);
		System.out.println("Sales Employee CReated");
		
	}
	
	
	
	
	@Override
	public double getNetSalary(int noOfDays) throws Exception{
		return (super.getNetSalary(noOfDays)+(super.getNetSalary(noOfDays)*getCommision()));
	}




	public long getTarget() {
		return target;
	}
	public void setTarget(long target) {
		this.target = target;
	}
	public double getCommision() {
		return commision;
	}
	public void setCommision(double commision) {
		this.commision = commision;
	}
	
	
}
