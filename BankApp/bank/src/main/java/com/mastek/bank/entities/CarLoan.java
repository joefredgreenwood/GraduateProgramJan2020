package com.mastek.bank.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CAR_LOAN")
@DiscriminatorValue("CAR")
public class CarLoan extends Loan {

	String carModel;
	int carYear;
	
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public int getCarYear() {
		return carYear;
	}
	public void setCarYear(int carYear) {
		this.carYear = carYear;
	}
	@Override
	public String toString() {
		return "CarLoan [carModel=" + carModel + ", carYear=" + carYear + ", loanId=" + loanId + ", loanValue="
				+ loanValue + ", durationNoOfMonths=" + durationNoOfMonths + "]";
	}
	
	
}
