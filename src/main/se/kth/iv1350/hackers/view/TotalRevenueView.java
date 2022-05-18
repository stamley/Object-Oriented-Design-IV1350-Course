package se.kth.iv1350.hackers.view;

import se.kth.iv1350.hackers.model.PaymentObserver;
/**
 * This class represents the view that prints the total revenue to the user interfacxe
 */
public class TotalRevenueView implements PaymentObserver{
    private double totalRevenue;

    /**
     * This is a constructor method for the TotalRevenueView
     */
    public TotalRevenueView(){
        this.totalRevenue = 0;
    }
    

    @Override
    public void updateTotal(double totalRevenue){
        this.totalRevenue += totalRevenue; 
        displayTotalRevenue();
    }

    public void displayTotalRevenue(){
        System.out.println("\n*******************************\n");
        System.out.println("Total revenue of all sale: " + this.totalRevenue);
        System.out.println("\n*******************************");
    }
}
