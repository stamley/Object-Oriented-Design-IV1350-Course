package se.kth.iv1350.hackers.model;

public interface PaymentObserver {
       /**
     * Updates the the chosen interface with the total revenue.
     * 
     * @param totalRevenue Total revenue of type double.
     */

   void updateTotal(double totalRevenue);
}
