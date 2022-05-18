package se.kth.iv1350.hackers.view;

import se.kth.iv1350.hackers.model.PaymentObserver;
import se.kth.iv1350.hackers.util.LogHandler;

/**
 * This class prints out the total revenue of all sales to a txt file
 */

public class TotalRevenueOutput implements PaymentObserver{
    private double totalRevenue;
    private LogHandler logHandler = new LogHandler("totalRevenue.txt");

    /**
     * This is a constructor method for TotalRevenueOutput
     */
    public TotalRevenueOutput() {
        this.totalRevenue = 0;
    }
  
    @Override
    public void updateTotal(double totalRevenue){
        this.totalRevenue += totalRevenue;
        logRevenueInFile();
        System.out.println("Printing the total revenue to new txt file...");

    }
    /**
     * This method logs the total revenue in the txt file. 
     */
    public void logRevenueInFile(){
        logHandler.log("The total revenue of all sales: "+ this.totalRevenue + " SEK");
        
    }
}
