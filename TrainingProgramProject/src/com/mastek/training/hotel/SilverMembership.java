package com.mastek.training.hotel;

public class SilverMembership extends HotelStandard {

	public SilverMembership() {
		super(); //Make sure you open a constructor inside the object!!
	}
	
	private double reduction;
	
	{
		setPrice(100);
		setReduction(0.8);
	}
	
	
	public double getReduction() {
		return reduction;
	}

	public void setReduction(double reduction) {
		this.reduction = reduction;
	}

	
	
	@Override
	public void calculateExtras() {
		// TODO Auto-generated method stu
		super.calculateExtras(); //As this needs calculateExtras to set extras you need to call this function first from super class
		setExtras(super.getExtras()*getReduction());
	}
	
	
	
}
