package com.mastek.training.hrapp;

public class EmailAnnouncement extends Announcement {

	
	
	// Each derived class has to override every abstract method and when you create the class it should automatically
	//tell you to override.
	@Override
	public void sendAnnouncement() {
		System.out.println("Sending Email to: "+getForGroup()+" By "+getFrom()+" With Title: "+getSubject()+" and Text: "+getContentText());

	}

}
