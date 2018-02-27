package calendar;


import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Random;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		 System.out.println("Start testing...");

		 try{
			 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				 long randomseed = System.currentTimeMillis(); //10
				 //			System.out.println(" Seed:"+randomseed );
				 Random random = new Random(randomseed);

				 int startHour = ValuesGenerator.RandInt(random);
				 int startMinute = ValuesGenerator.RandInt(random);
				 int startDay = ValuesGenerator.RandInt(random);
				 int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startYear = ValuesGenerator.RandInt(random);
				 String title = "Birthday Party";
				 String description = "This is my birthday party.";
				 //Construct a new Appointment object with the initial data
				 Appt appt = new Appt(startHour,
						 startMinute,
						 startDay,
						 startMonth,
						 startYear,
						 title,
						 description);

				 int startHour1 = ValuesGenerator.RandInt(random);
				 int startMinute1 = ValuesGenerator.RandInt(random);
				 int startDay1 = ValuesGenerator.RandInt(random);
				 int startMonth1 = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startYear1 = ValuesGenerator.RandInt(random);
				 String title1 = null;
				 String description1 = null;
				 Appt appt1 = new Appt(startHour1,
						 startMinute1,
						 startDay1,
						 startMonth1,
						 startYear1,
						 title1,
						 description1);

				 int y = ValuesGenerator.RandInt(random);
				 int m = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int d = ValuesGenerator.getRandomIntBetween(random, 1, 29);
				 GregorianCalendar cal = new GregorianCalendar(m, d, y);
				 CalDay calday = new CalDay(cal);

				 if (!appt.getValid()) continue;
				 if (!appt1.getValid()) continue;

				 int[] recurDaysArr={0,1,2};

				 appt.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
				 appt1.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
				 calday.addAppt(appt);
				 calday.addAppt(appt1);
				 Appt appt2 = new Appt();
				 calday.addAppt(appt2);


				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				 if ((iteration % 10000) == 0 && iteration != 0)
					 System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);
			 }

			 }catch(NullPointerException e){

			 }

			 System.out.println("Done testing...");


		 }


	
}
