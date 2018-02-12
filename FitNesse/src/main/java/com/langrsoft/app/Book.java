package com.langrsoft.app;

public class Book implements Material {
   protected static final int BOOK_CHECKOUT_PERIOD = 21;
   protected static final int BOOK_GRACE_PERIOD = 3;
   protected static final int BOOK_FINE = 10;

   public CheckoutConstraints getCheckoutConstraints() {
      return new CheckoutConstraints() {

         public int getCentsPerDay() {
            return BOOK_FINE;
         }

         public int getGracePeriod() {
            return BOOK_GRACE_PERIOD;
         }

         public int getPeriodAsDays() {
            return BOOK_CHECKOUT_PERIOD;
         }};
   }
}
