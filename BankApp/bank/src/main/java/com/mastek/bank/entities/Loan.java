package com.mastek.bank.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="PERSONAL_LOAN")
@DiscriminatorColumn(discriminatorType=DiscriminatorType.STRING, name="LOAN_TYPE")
@DiscriminatorValue("LOAN")
public class Loan {

	int loanId;
	double loanValue;
	int durationNoOfMonths;
	
	
	public Loan() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public double getLoanValue() {
		return loanValue;
	}
	public void setLoanValue(double loanValue) {
		this.loanValue = loanValue;
	}
	public int getDurationNoOfMonths() {
		return durationNoOfMonths;
	}
	public void setDurationNoOfMonths(int durationNoOfMonths) {
		this.durationNoOfMonths = durationNoOfMonths;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + loanId;
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
		Loan other = (Loan) obj;
		if (loanId != other.loanId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", loanValue=" + loanValue + ", durationNoOfMonths=" + durationNoOfMonths
				+ "]";
	}
	
	
	
	
	
}
