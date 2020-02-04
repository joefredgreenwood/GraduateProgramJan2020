package com.mastek.training.linkedin;

public class LinkedIn {

	public LinkedIn(){};
	
	
	
	private String Name;
	private Qualifications qualification;
	private Skills skill;
	private String certifications;
	private String job_details;
	
	{
		setName("Joe");
		setQualification(Qualifications.BSc);
		setSkill(Skills.JAVA);
		setCertifications("Agile");
		setJob_details("Learning");
		
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Qualifications getQualification() {
		return qualification;
	}
	public void setQualification(Qualifications qualification) {
		this.qualification = qualification;
	}
	public Skills getSkill() {
		return skill;
	}
	public void setSkill(Skills skill) {
		this.skill = skill;
	}
	public String getCertifications() {
		return certifications;
	}
	public void setCertifications(String certifications) {
		this.certifications = certifications;
	}
	public String getJob_details() {
		return job_details;
	}
	public void setJob_details(String job_details) {
		this.job_details = job_details;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
