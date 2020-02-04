package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mastek.training.passportInfo.Passport;
import com.mastek.training.passportInfo.PassportAccessObject;
import com.mastek.training.passportInfo.PassportJDBS;



class Passport_Tests {
	
	PassportAccessObject<Passport> pp1;

	@BeforeEach
	void setUp() throws Exception {
		pp1 = new PassportJDBS();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddPassport() {
		Passport pasp = new Passport();
		pasp.setPassportNumber(111);
		pasp.setName("Example");
		pasp.setDateOfBirth("15-02-1997");
		pasp.setCountry("UK");
		
		
		pasp = pp1.add(pasp); // returns the object if saved successfully
		assertNotNull(pasp,"Passport not added");
		
		Passport fetchPasp = pp1.find(111);
		assertNotNull(fetchPasp,"Passport not Found");
	}

	@Test
	void testListAllPassports() {
		Collection<Passport> pp2 = pp1.listAll();
		for (Passport passport:pp2) {
			System.out.println(passport);
		}
	}
	
	@Test
	void testRemovePassport() {
		Passport pasp = new Passport();
		pasp.setPassportNumber(18);
		pasp.setName("Remove Example");
		pasp.setDateOfBirth("26-06-1997");
		pasp.setCountry("UK");
		
		
		pasp = pp1.add(pasp); // returns the object if saved successfully
		assertNotNull(pasp,"Employee not added");
		
		Passport removedPasp = pp1.remove(18);
		assertNotNull(removedPasp,"Passport Not removed");
		
		Passport checkRemovedPasp = pp1.find(18);
		assertNull(checkRemovedPasp,"Passport Not removed"); //Checking that the removed value is no longer there.
		
	}
		
				
	}


