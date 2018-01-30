package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }

	 @Test
	  public void test02()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 Appt appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 appt.setStartHour(startHour);
		 appt.setStartMinute(startMinute);
		 appt.setStartDay(startDay);
		 appt.setStartMonth(startMonth);
		 appt.setStartYear(startYear);
		 appt.setTitle(title);
		 appt.setDescription(description);

		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());
	 }
//add more unit tests as you needed
	@Test
	public void test03()  throws Throwable  {
		int startHour=25;
		int startMinute=61;
		int startDay=33;
		int startMonth=12;
		int startYear=2018;
		String title=null;
		String description=null;
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		assertFalse(appt.getValid());

		startHour=21;
		appt.setStartHour(startHour);
		assertFalse(appt.getValid());

		startMinute=59;
		appt.setStartMinute(startMinute);
		assertFalse(appt.getValid());

		startDay=15;
		appt.setStartDay(startDay);
		startMonth=0;
		appt.setStartMonth(startMonth);
		assertFalse(appt.getValid());
	 }

	@Test
	public void test04()  throws Throwable  {
		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		int recurNumber=3;
		appt.setRecurNumber(recurNumber);

		assertEquals(3, appt.getRecurNumber());
		assertEquals(2, appt.getRecurBy());
		assertTrue(appt.isRecurring());
		assertEquals(0, appt.getRecurIncrement());

		int[] a = appt.getRecurDays();
	}

	@Test
	public void test05()  throws Throwable {
		int startHour = 21;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		Appt appt = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);

		int startHour1 = 21;
		int startMinute1 = 30;
		int startDay1 = 15;
		int startMonth1 = 01;
		int startYear1 = 2018;
		String title1 = "Birthday Party";
		String description1 = "This is my birthday party.";
		Appt appt1 = new Appt(startHour1,
				startMinute1,
				startDay1,
				startMonth1,
				startYear1,
				title1,
				description1);

		assertEquals(0, appt.compareTo(appt1));
	}

	@Test
	public void test06()  throws Throwable {
		int startHour = 21;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		Appt appt = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);
		String rep = "\t1/15/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n";

		assertEquals(rep, appt.toString());

		Appt appt1 = new Appt();
		assertEquals(null, appt1.toString());
	}

	@Test
	public void test07()  throws Throwable {
		int[] a = null;
	 	Appt appt = new Appt(10, 30, 8, 12, 2018,"title", "description");
		appt.setRecurrence( a, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
		Appt appt1 = new Appt(0, 30, 8, 12, 2018,"title", "description");
		assertEquals(0, appt1.getStartHour());
		appt1.toString();
	}
}
