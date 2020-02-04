package com.mastek.training.pack1; // An interface uses less memory as it doesn't extend from java.lan.object

public interface Shape {//An interface is a type which contains only method declarations and constants.

	
	double pi=Math.PI;
	
	
	
	public double getArea();
	public double getPerimeter();
	
	//All methods have to be abstract, there are no constructors and all variables are static and final
	
	
	
}
