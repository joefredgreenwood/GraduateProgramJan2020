package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mastek.training.basics.SolutionProvider;

class SolutionProviderTest {

	@Test
	void testgetMaxNumberValidParams() {
		assertEquals(10,SolutionProvider.getMaxNumber(10, 2),"Invalid Max Number Returned");
	}

	@Test
	void testGetMaxNumberEqual() {
	assertEquals(9,SolutionProvider.getMaxNumber(9, 9),"Invalid Max Number Returned");
	}
    @Test
	void testGetMaxLimitsforParams() {
    assertEquals(-2,SolutionProvider.getMaxNumber(-2, -110),"Invalid Max Number Returned");
	}
    @Test
    void testGetMaxNumberMaxLimitsForIntParams() {
    assertEquals(999999999,SolutionProvider.getMaxNumber(999999999, 2),"Invalid Max Number Returned");
    }
    
    @Test
    void testDivideNumbers() {
    assertEquals("4,0",SolutionProvider.divideNumbers(20, 5),"Division Doesn't Work");
    }
    
    @Test
    void testDivideNumbersRemainder() {
    assertEquals("3,4",SolutionProvider.divideNumbers(19, 5),"Division Doesn't Work");
    }
    
    @Test
    void testKmToMiles() {
    assertEquals(1,SolutionProvider.kmToMile(1.608),"Invalid Number Returned");
    }
    
    @Test
    void testRectangleToArea() {
    assertEquals("Rectangle area is 8",SolutionProvider.areaOfRectangle(2, 4),"Invalid Number Returned");
    }

    
    @Test
    void testGrade() {
    assertEquals("A",SolutionProvider.grade(81, 82, 83),"Invalid Number Returned");
    }
    
    @Test
    void testJourneyTime() {
    assertEquals(1,SolutionProvider.journeyTime(10, 10),"Invalid Number Returned");
    }
    
    @Test
    void testCircleArea() {
    assertEquals(3.14,SolutionProvider.circleArea(1),"Invalid Number Returned");
    }
    
    @Test
    void testMinValue() {
    assertEquals(3,SolutionProvider.minValue(3,5,7),"Invalid Number Returned");
    }
    
    

    
   


}


