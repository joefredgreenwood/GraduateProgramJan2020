package com.mastek.training.pack1;

public class Rectangle implements Shape{//A class using an interface doesn't 'extend' it 'implements' and can implement more than one interface


	private int width;
	private int length;

	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return getLength()*getWidth();
	}
	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 2*getLength()+2*getWidth();
	}

	


}
