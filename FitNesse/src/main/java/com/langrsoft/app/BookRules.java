package com.langrsoft.app;

import fit.*;

public class BookRules extends ColumnFixture {
   public int dailyFine() {
      return new Book().getCheckoutConstraints().getCentsPerDay();
   }
   
   public int gracePeriod() {
      return new Book().getCheckoutConstraints().getGracePeriod();
   }
   
   public int checkoutPeriod() {
      return new Book().getCheckoutConstraints().getPeriodAsDays();
   }
}
