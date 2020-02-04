package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mastek.training.hotel.GoldMembership;
import com.mastek.training.hotel.HotelStandard;
import com.mastek.training.hotel.PlatinumMembership;
import com.mastek.training.hotel.SilverMembership;

class StandardPackageTest {

	HotelStandard s1;
	SilverMembership s2;
	GoldMembership s3;
	PlatinumMembership s4;
	
	@BeforeEach
	public void setUpSTandardTestCase() {
		System.out.println("StartTest");
		s1 = new HotelStandard(); // this is key as you are making a new object which you will need
		s2 = new SilverMembership(); // "
		s3 = new GoldMembership();
		s4 = new PlatinumMembership();
	}
	
	@Test
	void testGetCompletePrice() {
		assertEquals(100760,s1.getTotalPrice(), "FAILED");
		System.out.println(s1.getTotalPrice());
	}
	
	@Test
	void testGetSilverCompletePrice() {
		
		
		assertEquals(81616,s2.getTotalPrice(), "FAILED");
		System.out.println(s2.getTotalPrice());
	}
	
	@Test
void testGetGoldCompletePrice() {
		
		
		assertEquals(72312,s3.getTotalPrice(), "FAILED");
		System.out.println(s3.getTotalPrice());
	}
	
	@Test
void testGetPlatinumCompletePrice() {
		
		
		assertEquals(1945130,s4.getTotalPrice(), "FAILED_Plat");
		System.out.println(s4.getTotalPrice());
	}

}
