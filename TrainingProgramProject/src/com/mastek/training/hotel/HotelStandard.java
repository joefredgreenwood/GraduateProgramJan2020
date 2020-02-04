package com.mastek.training.hotel;

import com.sun.org.apache.bcel.internal.generic.IfInstruction;

public class HotelStandard {

	private double price;
	private Locations location;
	private double contractLength;
	
	private int numberOfBikes;
	private double priceOfBikes;
	private double priceOfGym;
	private double priceOfYacht;
	private int numberOfYacht;
	private boolean gymUsage;
	private double extras;
	
	


	public static final int DEFAULT_ZERO=0;
	public static final int MIN_TERM=1;
	
	{
		setPrice(20.00);
		setContractLength(12);
		setLocation(Locations.LEEDS);
		setGymUsage(true);
		setPriceOfGym(10);
		setNumberOfBikes(4);
		setPriceOfBikes(100);
		setNumberOfYacht(1);
		setPriceOfYacht(100000);
		
	}
	
	

	
	
	public HotelStandard() {
		
	}
	public HotelStandard(double price,double contractLength,Locations location){
		this.setPrice(price);
		this.setContractLength(contractLength);
		this.setLocation(location);
				
	}
	
	
	
	
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		if(price>DEFAULT_ZERO) {
		this.price = price;}
	}
	public double getContractLength() {
		return contractLength;
	}
	public void setContractLength(double contractLength) {
		if(contractLength>MIN_TERM) {
		this.contractLength = contractLength;}
	}
	
	public Locations getLocation() {
		return location;
	}
	public void setLocation(Locations location) {
		this.location = location;
	}
	public int getNumberOfBikes() {
		return numberOfBikes;
	}
	public void setNumberOfBikes(int numberOfBikes) {
		this.numberOfBikes = numberOfBikes;
	}
	public double getPriceOfBikes() {
		return priceOfBikes;
	}
	public void setPriceOfBikes(double priceOfBikes) {
		this.priceOfBikes = priceOfBikes;
	}
	public double getPriceOfGym() {
		return priceOfGym;
	}
	public void setPriceOfGym(double priceOfGym) {
		this.priceOfGym = priceOfGym;
	}
	public double getPriceOfYacht() {
		return priceOfYacht;
	}
	public void setPriceOfYacht(double priceOfYacht) {
		this.priceOfYacht = priceOfYacht;
	}
	public int getNumberOfYacht() {
		return numberOfYacht;
	}
	public void setNumberOfYacht(int numberOfYacht) {
		this.numberOfYacht = numberOfYacht;
	}
	public boolean isGymUsage() {
		return gymUsage;
	}
	public void setGymUsage(boolean gymUsage) {
		this.gymUsage = gymUsage;
	}
	public double getExtras() {
		return extras;
	}
	public void setExtras(double extras) {
		this.extras = extras;
	}
	
	//Calculating Functions
	
	public void calculateExtras () {
		if(isGymUsage()){
			setExtras(getContractLength()*getPriceOfGym()+getNumberOfYacht()*getPriceOfYacht()+getNumberOfBikes()*getPriceOfBikes()); 
					}
		//^ is how we are setting extras so we put it inside the brackets of setExtras and use the getvalues
		else {
			setExtras(getNumberOfYacht()*getPriceOfYacht()+getNumberOfBikes()*getPriceOfBikes()); 
			}
	}
	
	public double getTotalPrice() {
		calculateExtras();
		if(getContractLength()>0) {
		return getContractLength()*getPrice()+getExtras();
		}
		else return DEFAULT_ZERO;
	}
	
	
	@Override
	public String toString() {
		return "HotelStandard [price=" + price + ", location=" + location + ", contractLength=" + contractLength + "]";
	}
	
	
	
	
}
