package com.mastek.training.hrapp;

public abstract class Announcement { //We declare abstract if any of the methods are abstract, or any from the base class not overidden.

	private String from;
	private String forGroup;
	private String subject;
	private String contentText;
	
	//We declare the method as abstract when we want derived class to define the logic of this method.
	public abstract void sendAnnouncement(); // Not putting {} means we are just declaring a method.
	// Abstract Methods can't use the word final and can't be private
	
	//Getter and Setters
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getForGroup() {
		return forGroup;
	}
	public void setForGroup(String forGroup) {
		this.forGroup = forGroup;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContentText() {
		return contentText;
	}
	public void setContentText(String contentText) {
		this.contentText = contentText;
	}
	
	
	
	
	
}
