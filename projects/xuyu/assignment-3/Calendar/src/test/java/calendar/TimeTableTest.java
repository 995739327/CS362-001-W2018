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
        
        LinkedList<CalDay> calDays = timetable.getApptRange(appts, firstDay, lastDay);
        assertTrue(calDays!=null);
        assertEquals(0, calDays.get(0).getMonth());
        assertEquals(2019, calDays.get(0).getYear());
        assertEquals(7, calDays.get(0).getDay());
        assertEquals(1, calDays.get(0).getSizeAppts());
        assertEquals("Birthday Party", calDays.get(0).getAppts().getFirst().getTitle());
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
        assertEquals(null, timetable.deleteAppt(appts, appt));
        
        LinkedList<Appt> appts1 = new LinkedList<Appt>();
        TimeTable timetable1 = new TimeTable();
        Appt appt1 = new Appt(11, 30, 18, 12, 2018,"title", "description");
        Appt appt2 = new Appt(12, 30, 03, 12, 2018,"title1", "description1");
        Appt appt3 = new Appt(13, 30, 04, 12, 2018,"title2", "description2");
        Appt appt4 = new Appt(14, 30, 05, 12, 2018,"title3", "description3");
        
        appts1.add(appt1);
        appts1.add(appt2);
        appts1.add(appt3);
        appts1.add(appt4);
        
        int [] a = {0,1,2,3};
        LinkedList<CalDay> cal_1 = timetable1.getApptRange(appts, day2, day1);
        assertEquals(1, cal_1.size());
        assertEquals(0, cal_1.get(0).getMonth()); //wrong? 12?
        assertEquals(0, cal_1.get(0).getSizeAppts());
        
        LinkedList<Appt> appts2 = timetable1.permute(appts1, a);
        assertEquals(4, appts2.size());
        assertEquals(12, appts2.getFirst().getStartMonth());
        assertEquals(18, appts2.getFirst().getStartDay());
        assertEquals("title", appts2.getFirst().getTitle());
        assertEquals("description", appts2.getFirst().getDescription());
        
        assertEquals(12, appts2.get(2).getStartMonth());
        assertEquals(4, appts2.get(2).getStartDay());
        assertEquals("title2", appts2.get(2).getTitle());
        assertEquals("description2", appts2.get(2).getDescription());
       
        assertEquals(12, appts2.get(3).getStartMonth());
        assertEquals(5, appts2.get(3).getStartDay());
        assertEquals("title3", appts2.get(3).getTitle());
        assertEquals("description3", appts2.get(3).getDescription());
        
        assertTrue(appt.isRecurring());
        assertEquals(3,appt.getRecurDays().length);
        assertFalse(appt1.isRecurring());
        assertEquals(0,appt1.getRecurDays().length);
        
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
    @Test
    public void test04() throws Throwable{
        GregorianCalendar day1 = new GregorianCalendar(2018, 12, 9);
        GregorianCalendar day2 = new GregorianCalendar(2018, 12, 8);
        GregorianCalendar day3 = new GregorianCalendar(2020, 12, 1);

        LinkedList<CalDay> cal = new LinkedList<CalDay>();
        LinkedList<Appt> appts = new LinkedList<Appt>();

        int[] recurDaysArr={2,3,4};
        Appt appt1 = new Appt(10, 30, 8, 12, 2018,"title1", "description1");
        appt1.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
        appts.add(appt1);

        Appt appt2 = new Appt(12, 30, 8, 12, 2018,"title2", "description2");
        appt2.setRecurrence( recurDaysArr, Appt.RECUR_BY_YEARLY, 1, Appt.RECUR_NUMBER_FOREVER);
        appts.add(appt2);

        Appt appt3 = new Appt(12, 30, 9, 12, 2018,"title3", "description3");
        appt3.setRecurrence( recurDaysArr, Appt.RECUR_BY_MONTHLY, 1, Appt.RECUR_NUMBER_FOREVER);
        appts.add(appt3);

        Appt appt4 = new Appt(16, 30, 9, 12, 2018,"title4", "description4");
        appt4.setRecurrence( recurDaysArr, Appt.RECUR_BY_MONTHLY, 1, Appt.RECUR_NUMBER_FOREVER);
        appts.add(appt4);

        TimeTable timetable = new TimeTable();

        cal = timetable.getApptRange(appts, day2, day1);
//        assertEquals(cal, timetable.getApptRange(appts, day2, day1));
        assertEquals("12/8/2018 at 10:30am ,title1, description1",
        		cal.get(0).getAppts().get(0).toString().trim());
        assertEquals("12/8/2018 at 12:30pm ,title2, description2",
        		cal.get(0).getAppts().get(1).toString().trim());

        LinkedList<CalDay> cal1 = new LinkedList<CalDay>();
        cal1 = timetable.getApptRange(appts, day2, day3);
//        assertEquals(cal1, timetable.getApptRange(appts, day2, day3));

        Appt appt_5 = new Appt(12, 11, 15, 5, 2018,"title5", "description5");
        appt_5.setRecurrence( recurDaysArr, Appt.RECUR_BY_MONTHLY, 1, Appt.RECUR_NUMBER_FOREVER);
        appts.add(appt_5);

    }

    @Test
    public void test05() throws Throwable{
        TimeTable timetable = new TimeTable();
        GregorianCalendar firstDay = new GregorianCalendar(2018, 01, 01);
        GregorianCalendar lastDay = new GregorianCalendar(2018, 01, 04);

        LinkedList<Appt> appts = new LinkedList<Appt>();

        int[] recurDaysArr={2,3,4};
        Appt appt1 = new Appt(10, 30, 01, 01, 2018,"title1", "description1");
        appt1.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
        appts.add(appt1);

        Appt appt2 = new Appt(12, 30, 01, 03, 2018,"title2", "description2");
        appt2.setRecurrence( recurDaysArr, Appt.RECUR_BY_YEARLY, 1, Appt.RECUR_NUMBER_FOREVER);
        appts.add(appt2);

        LinkedList<CalDay> cal = new LinkedList<CalDay>();
//        assertEquals(timetable.getApptRange(appts, firstDay, lastDay),timetable.getApptRange(appts, firstDay, lastDay));
/*        LinkedList<Appt> appts1 = new LinkedList<Appt>();
        appts1.add(appt1);
        appts1.add(appt2);
        timetable.deleteAppt(appts,appt1);
        assertEquals(appts1,appts);
        timetable.deleteAppt(appts,appt2);
        assertEquals(appts1,appts);

        Appt appt3 = new Appt();
        LinkedList<Appt> appts3 = new LinkedList<Appt>();
        timetable.deleteAppt(appts3,appt3);
        assertEquals(null,);*/

    }

    //add more unit tests as you needed
    @Test
    public void test06(){
    	TimeTable timetable=new TimeTable();
        LinkedList<Appt> appts = new LinkedList<Appt>();
    	GregorianCalendar lastDay = new GregorianCalendar(2018, 12, 07);
        GregorianCalendar firstDay = new GregorianCalendar(2018, 12, 12);
        try {
			LinkedList<CalDay> calDays = timetable.getApptRange(appts, firstDay, lastDay);
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
        
        Appt appt1 = new Appt(10, 2, 8, 12, 2018,"title1", "description1");
        LinkedList<Appt> appts_test = timetable.deleteAppt(null, appt1);
        assertEquals(null, appts_test);
        
        appts_test = timetable.deleteAppt(appts, appt1);
        assertEquals(null, appts_test);
        
        Appt appt2 = new Appt(10, 2, 7, 12, 2018,"title2", "description2");
        appts.add(appt1);
        appts.add(appt2);
        assertEquals(2, appts.size());
        appts_test = timetable.deleteAppt(appts, appt1);
        assertEquals(1, appts_test.size());
        assertEquals("title2", appts_test.get(0).getTitle());
        
    }
    
    @Test
    public void test07(){
    	 LinkedList<Appt> appts1 = new LinkedList<Appt>();
         TimeTable timetable1 = new TimeTable();
         Appt appt1 = new Appt(11, 30, 18, 12, 2018,"0", "description");
         Appt appt2 = new Appt(12, 30, 03, 12, 2018,"1", "description1");
         Appt appt3 = new Appt(13, 30, 04, 12, 2018,"2", "description2");
         Appt appt4 = new Appt(14, 30, 05, 12, 2018,"3", "description3");
         
         appts1.add(appt1);
         appts1.add(appt2);
         appts1.add(appt3);
         
         int [] a = {2,3,1,0};
         try{
        	 timetable1.permute(appts1, a);
         }catch (Exception e) {
        	 assertTrue(e instanceof IllegalArgumentException);
		}
         
         appts1.add(appt4);
         LinkedList<Appt> appts2 = timetable1.permute(appts1, a);
         for (Appt appt : appts2) {
			System.out.println(appt);
		}
         
         
    }
    
}
