package com.langrsoft.app;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

public class CheckoutTest {
   private static int gracePeriod;
   private static final int PERIOD_AS_DAYS = 10;
   private static final int FINE = 10;

   private static final Date CHECKOUT_DATE = new Date();

  private Checkout checkout = new Checkout(material, CHECKOUT_DATE);
   
   private static CheckoutConstraints constraints = new CheckoutConstraints() {
      public int getCentsPerDay() {
         return FINE;
      }

      public int getGracePeriod() {
         return gracePeriod;
      }

      public int getPeriodAsDays() {
         return PERIOD_AS_DAYS;
      }
   };

   
   private static final Material material = new Material() {
      public CheckoutConstraints getCheckoutConstraints() {
         return constraints;
      }
   };

   @Test
   public void create() {
      assertSame(material, checkout.getMaterial());
      assertEquals(CHECKOUT_DATE, checkout.getCheckoutDate());
      assertFalse(checkout.isReturned());
      assertNull(checkout.getReturnDate());
      assertEquals(DateUtil.addDays(CHECKOUT_DATE, PERIOD_AS_DAYS), checkout.getDueDate());
   }
   
   @Test
   public void returnBeforeDue() {
      gracePeriod = 0;
      Date returnDateBeforeDue = DateUtil.addDays(checkout.getDueDate(), -1);
      checkout.returnOn(returnDateBeforeDue);
      assertReturned(returnDateBeforeDue);
      assertEquals(0, checkout.daysLate());
      assertTrue(checkout.isInGracePeriod());
      assertEquals(0, checkout.amountToFine());
   }

   @Test
   public void returnOnDueDate() {
      gracePeriod = 0;
      checkout.returnOn(checkout.getDueDate());
      assertReturned(checkout.getDueDate());
      assertEquals(0, checkout.daysLate());
      assertTrue(checkout.isInGracePeriod());
      assertEquals(0, checkout.amountToFine());
   }
   
   @Test
   public void returnOneDayLateNoGrace() {
      gracePeriod = 0;
      Date oneDayLate = DateUtil.addDays(checkout.getDueDate(), 1);
      checkout.returnOn(oneDayLate);
      assertReturned(oneDayLate);
      assertEquals(1, checkout.daysLate());
      assertFalse(checkout.isInGracePeriod());
      assertEquals(FINE, checkout.amountToFine());
   }
   
   @Test
   public void returnJustPastGracePeriod() { 
      gracePeriod = 3;
      int daysLate = gracePeriod + 1;
      Date lateDay = DateUtil.addDays(checkout.getDueDate(), daysLate);
      checkout.returnOn(lateDay);
      assertReturned(lateDay);
      assertEquals(daysLate, checkout.daysLate());
      assertFalse(checkout.isInGracePeriod());
      assertEquals(daysLate * FINE, checkout.amountToFine());
   }
   
   @Test
   public void returnAtEndOfGracePeriod() { 
      gracePeriod = 3;
      Date endOfGrace = DateUtil.addDays(checkout.getDueDate(), gracePeriod);
      checkout.returnOn(endOfGrace);
      assertReturned(endOfGrace);
      assertEquals(gracePeriod, checkout.daysLate());
      assertTrue(checkout.isInGracePeriod());
      assertEquals(0, checkout.amountToFine());
   }
   
   private void assertReturned(Date expectedReturnDate) {
      assertTrue(checkout.isReturned());
      assertEquals(expectedReturnDate, checkout.getReturnDate());
   }
}
