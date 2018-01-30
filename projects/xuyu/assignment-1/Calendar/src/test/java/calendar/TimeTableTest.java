package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		TimeTable timetable=new TimeTable();
		LinkedList<Appt> appts = new LinkedList<Appt>();
		GregorianCalendar firstDay = new GregorianCalendar(2018, 12, 07);
		GregorianCalendar lastDay = new GregorianCalendar(2018, 12, 12);

		 int startHour=21;
		 int startMinute=30;
		 int startDay=07;
		 int startMonth=12;
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

		 int startHour1=20;
		 int startMinute1=00;
		 int startDay1=12;
		 int startMonth1=12;
		 int startYear1=2018;
		 String title1=null;
		 String description1=null;
		 Appt appt1 = new Appt(startHour1,
				 startMinute1 ,
				 startDay1 ,
				 startMonth1 ,
				 startYear1 ,
				 title1,
				 description1);
		appts.push(appt);
		appts.push(appt1);

		timetable.getApptRange(appts, firstDay, lastDay);
	 }

	 @Test
	  public void test02()  throws Throwable  {
	 	int[] recurDaysArr={2,3,4};
	 	LinkedList<Appt> appts = new LinkedList<Appt>();
	 	GregorianCalendar day1 = new GregorianCalendar(2018, 12, 9);
	 	GregorianCalendar day2 = new GregorianCalendar(2018, 12, 8);
	 	int startHour1=20;
	 	int startMinute1=00;
	 	int startDay1=12;
	 	int startMonth1=12;
	 	int startYear1=2018;
	 	String title1=null;
	 	String description1=null;
	 	Appt appt = new Appt(startHour1,
				 startMinute1 ,
				 startDay1 ,
				 startMonth1 ,
				 startYear1 ,
				 title1,
				 description1);
		appt.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
		appts.push(appt);

		TimeTable timetable = new TimeTable();
//		LinkedList<CalDay> calday = new LinkedList<CalDay>();
//		calday=timetable.getApptRange(appts, day2, day1);
		LinkedList<CalDay> calday1 = new LinkedList<CalDay>();
		calday1=timetable.getApptRange(appts, day2, day1);

		LinkedList<Appt> appts_test = new LinkedList<Appt>();
		appts_test = timetable.deleteAppt(appts, appt);

		LinkedList<Appt> appts1 = new LinkedList<Appt>();
		TimeTable timetable1 = new TimeTable();
		Appt appt1 = new Appt(11, 30, 18, 12, 2018,"title", "description");
		Appt appt2 = new Appt(12, 30, 03, 12, 2018,"title", "description");
		Appt appt3 = new Appt(13, 30, 04, 12, 2018,"title", "description");
		Appt appt4 = new Appt(14, 30, 05, 12, 2018,"title", "description");

 		appts1.add(appt1);
 		appts1.add(appt2);
 		appts1.add(appt3);
 		appts1.add(appt4);

 		int [] a = {0,1,2,3};
 		LinkedList<CalDay> cal_1 = new LinkedList<CalDay>();
 		cal_1 = timetable1.getApptRange(appts, day2, day1);
 		LinkedList<Appt> appts2 = timetable1.permute(appts1, a);
	 }
	@Test
	public void test03()  throws Throwable  {
		LinkedList<Appt> appts = new LinkedList<Appt>();
		int[] recurDaysArr={0,1,2};
		Appt appt = new Appt(10, 30, 8, 12, 2018,"title", "description");
		appt.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
		appts.add(appt);


		Appt appt1 = new Appt(12, 30, 8, 12, 2018,"title", "description");
		appt1.setRecurrence( recurDaysArr, Appt.RECUR_BY_YEARLY, 1, Appt.RECUR_NUMBER_FOREVER);
		appts.add(appt1);

		Appt appt2 = new Appt(12, 30, 9, 12, 2018,"title", "description");
		appt2.setRecurrence( recurDaysArr, Appt.RECUR_BY_MONTHLY, 1, Appt.RECUR_NUMBER_FOREVER);
		appts.add(appt2);

		Appt appt3 = new Appt(16, 30, 9, 12, 2018,"title", "description");
		appt3.setRecurrence( recurDaysArr, Appt.RECUR_BY_MONTHLY, 1, Appt.RECUR_NUMBER_FOREVER);
		appts.add(appt3);

		TimeTable timetable = new TimeTable();

		timetable.deleteAppt(appts, appt);
		timetable.deleteAppt(appts, appt1);
		timetable.deleteAppt(appts, appt2);
		timetable.deleteAppt(appts, appt3);

		Appt appt4 = null;
		appts.add(appt4);
		assertEquals(null, timetable.deleteAppt(appts,appt4));

		Appt appt5 = new Appt();
		appts.add(appt5);
		assertEquals(null, timetable.deleteAppt(appts,appt5));
	}
//add more unit tests as you needed
}
