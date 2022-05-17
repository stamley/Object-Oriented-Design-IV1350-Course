package se.kth.iv1350.hackers.view;

import se.kth.iv1350.hackers.model.PaymentObserver;

public class TotalRevenueView implements PaymentObserver{
    private double totalRevenue;

    public TotalRevenueView(){
        this.totalRevenue = 0;
    }
    
    /**
     * Updates the user interface with the total revenue.
     * 
     * @param totalRevenue Total revenue of type double.
     */

    @Override
    public void updateTotal(double totalRevenue){
        this.totalRevenue += totalRevenue; 
        displayTotalRevenue();
    }

    public void displayTotalRevenue(){
        System.out.println("*****************************\n");
        System.out.println("Total revenue of all sale: " + totalRevenue);
        System.out.println("\n*****************************");
    }
}
