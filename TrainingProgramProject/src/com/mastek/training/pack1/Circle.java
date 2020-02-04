package com.mastek.training.pack1;

public class Circle implements Shape{

	private int radius;
	
	
	
	
	
	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return pi*Math.pow(radius, 2);
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return pi*2*radius;
	}


	
}
