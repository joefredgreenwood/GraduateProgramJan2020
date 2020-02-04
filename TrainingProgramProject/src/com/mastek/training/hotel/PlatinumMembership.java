package com.mastek.training.hotel;

public class PlatinumMembership extends GoldMembership {
	public PlatinumMembership() {

		super();
	}
	{
		setPrice(10000);
		setReduction(0.5);
		setPriceOfMasseuseTikiGirls(15000);
		setNumberOfMasseuseTikiGirls(10);
		
	}


	private int numberOfMasseuseTikiGirls;
	private double priceOfMasseuseTikiGirls;


	public int getNumberOfMasseuseTikiGirls() {
		return numberOfMasseuseTikiGirls;
	}
	public void setNumberOfMasseuseTikiGirls(int numberOfMasseuseTikiGirls) {
		this.numberOfMasseuseTikiGirls = numberOfMasseuseTikiGirls;
	}
	public double getPriceOfMasseuseTikiGirls() {
		return priceOfMasseuseTikiGirls;
	}
	public void setPriceOfMasseuseTikiGirls(double priceOfMasseuseTikiGirls) {
		this.priceOfMasseuseTikiGirls = priceOfMasseuseTikiGirls;
	}


	@Override
	public void calculateExtras() {
		
		
		super.calculateExtras();
		setExtras((super.getExtras()*getReduction())+(getNumberOfMasseuseTikiGirls()*getPriceOfMasseuseTikiGirls()*getContractLength()));
		
		
		
	}













}

