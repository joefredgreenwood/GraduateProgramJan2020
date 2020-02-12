package com.mastek.bank.entities;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="HOME_LOAN")
@DiscriminatorValue("HOME")
public class HomeLoan extends Loan {

	String homeType;
	int houseAge;
	
	public String getHomeType() {
		return homeType;
	}
	public void setHomeType(String homeType) {
		this.homeType = homeType;
	}
	public int getHouseAge() {
		return houseAge;
	}
	public void setHouseAge(int houseAge) {
		this.houseAge = houseAge;
	}
	@Override
	public String toString() {
		return "HomeLoan [homeType=" + homeType + ", houseAge=" + houseAge + ", loanId=" + loanId + ", loanValue="
				+ loanValue + ", durationNoOfMonths=" + durationNoOfMonths + "]";
	}
	
	
}
