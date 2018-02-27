package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.LinkedList;
import java.util.List;
import java.util.GregorianCalendar;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;
    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		 System.out.println("Start testing...");

		 try {
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

				 LinkedList<Appt> appts = new LinkedList<Appt>();
				 int[] recurDaysArr={0,1,2};
				 appt.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
				 appt1.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
				 if (!appt.getValid()) continue;
				 if (!appt1.getValid()) continue;

				 TimeTable timetable = new TimeTable();
				 appts.add(appt);
				 appts.add(appt1);

				 LinkedList<Appt> appts1 = new LinkedList<Appt>();
				 timetable.deleteAppt(appts1, null);
				 Appt appt2 = new Appt();
				 timetable.deleteAppt(appts, appt2);
				 appts.push(appt2);
				 timetable.deleteAppt(appts, appt2);

				 LinkedList<Appt> appts_test = timetable.deleteAppt(null, appt);
				 appts_test = timetable.deleteAppt(appts1, appt1);

				 appts_test = timetable.deleteAppt(appts, appt);
				 appts_test = timetable.deleteAppt(appts, appt1);

				 GregorianCalendar firstDay = new GregorianCalendar(2018, 12, 07);
				 GregorianCalendar lastDay = new GregorianCalendar(2018, 12, 12);
				 LinkedList<CalDay> calDays = timetable.getApptRange(appts, firstDay, lastDay);
//				 calDays = timetable.getApptRange(appts, lastDay, firstDay);
				 calDays = timetable.getApptRange(appts1, firstDay, lastDay);

				 appts1.add(appt);
				 calDays = timetable.getApptRange(appts1, firstDay, lastDay);

				 GregorianCalendar day1 = new GregorianCalendar(2018, 12, 9);
				 GregorianCalendar day2 = new GregorianCalendar(2018, 12, 8);
				 GregorianCalendar day3 = new GregorianCalendar(2020, 12, 1);
				 LinkedList<CalDay> cal = new LinkedList<CalDay>();
				 cal = timetable.getApptRange(appts, day2, day1);
				 LinkedList<CalDay> cal1 = new LinkedList<CalDay>();
				 cal1 = timetable.getApptRange(appts, day2, day3);

				 LinkedList<Appt> appts2 = new LinkedList<Appt>();
				 try {
					 calDays = timetable.getApptRange(appts2, firstDay, lastDay);
				 } catch (DateOutOfRangeException e) {
					 assertEquals("Second date specified is not  before the first date specified.", e.getMessage());
				 }

				 try {
					 firstDay = new GregorianCalendar(2018, 12, 07);
					 lastDay = new GregorianCalendar(2018, 12, 12);
					 timetable.getApptRange(null, firstDay, lastDay);
				 } catch (Exception e) {
					 assertTrue(e instanceof NullPointerException);
				 }

				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				 if ((iteration % 10000) == 0 && iteration != 0)
					 System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);

			 }
		 }catch(NullPointerException e){

		 }

		 System.out.println("Done testing...");
	 }


	
}
