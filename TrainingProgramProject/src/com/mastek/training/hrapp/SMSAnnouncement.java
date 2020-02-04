package com.mastek.training.hrapp;

public class SMSAnnouncement extends Announcement {

	@Override
	public void sendAnnouncement() {
		System.out.println("Sending SMS to: "+getForGroup()+" By "+getFrom()+" With Title: "+getSubject()+" and Text: "+getContentText());

	}

}
