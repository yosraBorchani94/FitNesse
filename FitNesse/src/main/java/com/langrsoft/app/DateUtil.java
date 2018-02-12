package com.langrsoft.app;

import java.util.*;

public class DateUtil {
   private static final Calendar CALENDAR = Calendar.getInstance();
   private static final Calendar CALENDAR2 = Calendar.getInstance();

   public static Date addDays(Date date, int days) {
      CALENDAR.setTime(date);
      CALENDAR.add(Calendar.DAY_OF_YEAR, days);
      return CALENDAR.getTime();
   }

   public static Date createDate(int year, int month, int dayOfMonth) {
      CALENDAR.set(Calendar.YEAR, year);
      CALENDAR.set(Calendar.MONTH, month);
      CALENDAR.set(Calendar.DAY_OF_MONTH, dayOfMonth);
      return CALENDAR.getTime();
   }

   public static int daysAfter(Date earlierDate, Date laterDate) {
      final Calendar earlier = CALENDAR;
      final Calendar later = CALENDAR2;

      if (laterDate.before(earlierDate))
         return 0;

      earlier.setTime(earlierDate);
      later.setTime(laterDate);

      int daysLater = later.get(Calendar.DAY_OF_YEAR) - earlier.get(Calendar.DAY_OF_YEAR);
      for (int year = earlier.get(Calendar.YEAR); year < later.get(Calendar.YEAR); year++) {
         earlier.set(Calendar.YEAR, year);
         daysLater += earlier.getActualMaximum(Calendar.DAY_OF_YEAR);
      }

      return daysLater;
   }
}
