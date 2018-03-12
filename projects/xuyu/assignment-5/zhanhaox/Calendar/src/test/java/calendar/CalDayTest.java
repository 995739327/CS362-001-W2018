package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {
    
    @Test
    public void test01()  throws Throwable  {
        CalDay calday=new CalDay();
        assertFalse(calday.isValid());
        assertEquals(null, calday.iterator());
        
        GregorianCalendar cal=new GregorianCalendar(01, 01, 2018);
        CalDay calday1=new CalDay(cal);
        assertTrue(calday1.isValid());
        calday1.iterator();
        int month = calday1.getMonth();
        int year = calday1.getYear();
        int day = calday1.getDay();
        
    }
    @Test
    public void test02()  throws Throwable  {
        GregorianCalendar cal=new GregorianCalendar(01, 01, 2018);
        CalDay calday=new CalDay(cal);
        assertTrue(calday.isValid());
        assertEquals(0, calday.getSizeAppts());
        assertEquals(11, calday.getDay());
        assertEquals(7, calday.getMonth());
        assertEquals(6, calday.getYear());
        
    }
    @Test
    public void test03()  throws Throwable  {
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
        
        int startHour1=20;
        int startMinute1=00;
        int startDay1=10;
        int startMonth1=01;
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
        
        GregorianCalendar cal=new GregorianCalendar(01, 01, 2018);
        CalDay calday=new CalDay(cal);
        calday.addAppt(appt);
        calday.addAppt(appt1);
    }
    
    @Test
    public void test04()  throws Throwable  {
        GregorianCalendar cal=new GregorianCalendar(01, 01, 2018);
        CalDay calday=new CalDay(cal);
        CalDay calday1=new CalDay(cal);
        
        assertEquals(calday1.toString(), calday.toString());
    }
    //add more unit tests as you needed
    
    @Test
    public void test05()  throws Throwable  {
        int[] recurDaysArr={0,1,2};
        LinkedList<Appt> appts = new LinkedList<Appt>();
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
        
        GregorianCalendar cal=new GregorianCalendar(01, 01, 2018);
        CalDay calday=new CalDay(cal);
        //assertEquals(0, appts.size());
//        calday.setAppts(appts);
        
        Appt appt4 = new Appt();
        
        calday.addAppt(appt);
        calday.addAppt(appt1);
        calday.addAppt(appt2);
        calday.addAppt(appt3);
        calday.addAppt(appt4);
        
        String a = calday.toString();
        
        LinkedList<Appt> appts1 = new LinkedList<Appt>();
        CalDay calday1 = new CalDay();
        assertEquals(0, appts1.size());
        //assertEquals(null, appts1);
//        calday1.setAppts(appts1);
    }

    @Test
    public void test06()  throws Throwable  {
        Appt appt = new Appt(10, 20, 8, 12, 2018,"title", "description");
        int[] a = {0,1,2};
        int b = 3;
        appt.setRecurrence(a,b,b,b);

        GregorianCalendar cal=new GregorianCalendar(01, 01, 2018);
        CalDay calday=new CalDay(cal);

        calday.addAppt(appt);
        assertEquals(calday.getAppts(), calday.getAppts());

        Appt appt1 = new Appt(10, 20, 8, 12, 2018,"title", "description");
        calday.addAppt(appt1);
        LinkedList<Appt> appts = new LinkedList<Appt>();
        appts.add(appt);
        appts.add(appt1);
        assertEquals(appts, calday.getAppts());

        GregorianCalendar cal1=new GregorianCalendar(01, 01, 2018);
        CalDay calday1=new CalDay(cal1);

        calday1.setAppts(appts);
        assertEquals(appts, calday1.getAppts());

        LinkedList<Appt> appts2 = new LinkedList<Appt>();
        CalDay calday2=new CalDay(cal1);
        calday2.setAppts(appts2);
        assertEquals(appts2, calday2.getAppts());

        CalDay calday3 = new CalDay();
        assertEquals("", calday3.toString());

        String s = "\t --- 7/11/6 --- \n" +
                " --- -------- Appointments ------------ --- \n" + "\n";
        assertEquals(s, calday2.toString());

 //       assertEquals(calday2.iterator(), calday2.iterator());
    }
}
