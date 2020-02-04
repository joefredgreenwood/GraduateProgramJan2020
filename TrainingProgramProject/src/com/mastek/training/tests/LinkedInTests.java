package com.mastek.training.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mastek.training.linkedin.LinkedIn;

class LinkedInTests {

	LinkedIn l1;
	
	
	@BeforeEach
	public void setUpSTandardTestCase() {
	l1 = new LinkedIn();
	
	}
	
	
	
	@Test
	void linkedInApptest() {
		System.out.println(l1.getName()+l1.getQualification()+l1.getSkill()+l1.getCertifications()+l1.getJob_details());;
	}

}
