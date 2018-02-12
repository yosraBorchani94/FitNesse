package com.langrsoft.app;

import static org.junit.Assert.*;
import static com.langrsoft.app.DateUtil.*;

import java.util.*;

import org.junit.*;

public class DateUtilTest {
   private static final Date FIRST_OF_NOVEMBER = createDate(2006, Calendar.NOVEMBER, 1);
   private static final Calendar calendar1 = Calendar.getInstance();
   private static final Calendar calendar2 = Calendar.getInstance();

   @Test
   public void create() {
      Date date = DateUtil.createDate(2006, Calendar.JANUARY, 1);

      calendar1.setTime(date);
      assertEquals(2006, calendar1.get(Calendar.YEAR));
      assertEquals(Calendar.JANUARY, calendar1.get(Calendar.MONTH));
      assertEquals(1, calendar1.get(Calendar.DAY_OF_MONTH));
   }
   
   @Test
   public void addDaysToDate() {
      assertDateEqual(createDate(2006, Calendar.NOVEMBER, 2), addDays(FIRST_OF_NOVEMBER, 1));
      assertDateEqual(createDate(2006, Calendar.DECEMBER, 1), addDays(FIRST_OF_NOVEMBER, 30));
      assertDateEqual(createDate(2007, Calendar.JANUARY, 1), addDays(FIRST_OF_NOVEMBER, 61));
   }
   
   @Test
   public void daysAfterDate() {
      assertEquals(0, daysAfter(FIRST_OF_NOVEMBER, createDate(2006, Calendar.NOVEMBER, 1)));
      assertEquals(1, daysAfter(FIRST_OF_NOVEMBER, createDate(2006, Calendar.NOVEMBER, 2)));
   }
   
   @Test
   public void daysAfterAlwaysZeroIfSecondDateBeforeFirst() {
      assertEquals(0, daysAfter(FIRST_OF_NOVEMBER, createDate(2006, Calendar.OCTOBER, 31)));
   }
   
   @Test
   public void daysAfterAcrossMonthBoundary() {
      assertEquals(30, daysAfter(FIRST_OF_NOVEMBER, createDate(2006, Calendar.DECEMBER, 1)));
   }

   @Test
   public void daysAfterAcrossYearBoundary() {
      assertEquals(61, daysAfter(FIRST_OF_NOVEMBER, createDate(2007, Calendar.JANUARY, 1)));
   }
   
   @Test
   public void daysAfterAcrossMultipleYears() {
      Date lastOf2007 = createDate(2007, Calendar.DECEMBER, 31);
      Date firstOf2009 = createDate(2009, Calendar.JANUARY, 1);
      int daysIn2008 = 366;
      assertEquals(daysIn2008 + 1, daysAfter(lastOf2007, firstOf2009));
   }
   
   private void assertDateEqual(Date expected, Date actual) {
      calendar1.setTime(expected);
      calendar2.setTime(actual);
      
      assertEquals(calendar1.get(Calendar.YEAR), calendar2.get(Calendar.YEAR));
      assertEquals(calendar1.get(Calendar.MONTH), calendar2.get(Calendar.MONTH));
      assertEquals(calendar1.get(Calendar.DAY_OF_MONTH), calendar2.get(Calendar.DAY_OF_MONTH));
   }
}
