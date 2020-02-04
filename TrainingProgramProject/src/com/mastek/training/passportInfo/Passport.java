package com.mastek.training.passportInfo;

public class Passport {

	private long passportNumber;
	private String name;
	private String dateOfBirth;
	private String country;
	
	public Passport(long passportNumber) {
		this.setPassportNumber(passportNumber);
	}
	
	
	public Passport() {
		// TODO Auto-generated constructor stub
	}


	// Getters and Setters
	public long getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(long passportNumber) {
		this.passportNumber = passportNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}


	@Override
	public String toString() {
		return "Passport [passportNumber=" + passportNumber + ", name=" + name + ", dateOfBirth=" + dateOfBirth
				+ ", country=" + country + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (passportNumber ^ (passportNumber >>> 32));
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
		Passport other = (Passport) obj;
		if (passportNumber != other.passportNumber)
			return false;
		return true;
	}
	
	

}
