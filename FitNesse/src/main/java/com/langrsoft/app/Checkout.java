package com.langrsoft.app;

import java.util.*;

public class Checkout {
   private Date checkoutDate;
   private Material material;
   private Date returnDate;

   public Checkout(Material material, Date checkoutDate) {
      this.material = material;
      this.checkoutDate = checkoutDate;
   }
   
   public Material getMaterial() {
      return material;
   }

   public Date getCheckoutDate() {
      return checkoutDate;
   }

   public boolean isReturned() {
      return returnDate != null;
   }

   public Date getReturnDate() {
      return returnDate;
   }

   public void returnOn(Date date) {
      returnDate = date;
   }

   public int daysLate() {
      return DateUtil.daysAfter(getDueDate(), returnDate);
   }

   public Date getDueDate() {
      return DateUtil.addDays(checkoutDate, material.getCheckoutConstraints().getPeriodAsDays());
   }

   public boolean isInGracePeriod() {
      return daysLate() <= material.getCheckoutConstraints().getGracePeriod();
   }

   public int amountToFine() {
      if (isInGracePeriod())
         return 0;
      return daysLate() * material.getCheckoutConstraints().getCentsPerDay();
   }
}
