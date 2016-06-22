package jUnitTests;

import static org.junit.Assert.*;
import org.junit.Test;
import dateUtility.*;

public class DateUtilityTests {

	@Test
	public void getLastDayOfMonthTest1() {		
		assertTrue(DateUtility.getLastDayOfMonth(6, 2016) == 30);
	}
	@Test
	public void getLastDayOfMonthTest2() {		
		assertTrue(DateUtility.getLastDayOfMonth(5, 2016) == 31);		
	}
	@Test
	public void getLastDayOfMonthTest3() {		
		assertTrue(DateUtility.getLastDayOfMonth(2, 2016) == 29);		
	}
	
	@Test
	public void getDayOfWeekTest1() {		
		assertEquals(DateUtility.getDayOfWeek(5,29,2016), "Sunday");		
	}
	@Test
	public void getDayOfWeekTest2() {		
		assertEquals(DateUtility.getDayOfWeek(6,22, 2016), "Wednesday");		
	}
	@Test
	public void getDayOfWeekTest3() {		
		assertEquals(DateUtility.getDayOfWeek(7,9, 2016), "Saturday");		
	}
	
	@Test
	public void subtractTwoDatesTest1() {	
		//System.out.println(DateUtility.subtractTwoDates(6,22,2016, 6,1,2016));;
		assertTrue(DateUtility.subtractTwoDates(6,22,2016, 6,1, 2016)==21);
	}
	@Test
	public void subtractTwoDatesTest2() {	
		assertTrue(DateUtility.subtractTwoDates(6,22,2016, 6,22,2015)==366);
	}
	@Test
	public void subtractTwoDatesTest3() {	
		assertTrue(DateUtility.subtractTwoDates(6,22,2016, 6,18, 2016)==4);
	}
	
	@Test
	public void toStringTest1() {	
		//System.out.println(DateUtility.toString(0, 0, 0, "*"));
		assertEquals(DateUtility.toString(0, 0, 0, "*"), "0*0*0");		
	}
	@Test
	public void toStringTest2() {		
		assertEquals(DateUtility.toString(6, 22, 2016, "-"), "6-22-2016");		
	}
	@Test
	public void toStringTest3() {		
		assertEquals(DateUtility.toString(12, 31, 2016, "/"), "12/31/2016");		
	}

	@Test
	public void isLeapYearTest1() {		
		assertTrue(!DateUtility.isLeapYear(2015));
	}
	@Test
	public void isLeapYearTest2() {		
		assertTrue(DateUtility.isLeapYear(2016));
	}
	@Test
	public void isLeapYearTest3() {		
		assertTrue(DateUtility.isLeapYear(2000));
	}
}
