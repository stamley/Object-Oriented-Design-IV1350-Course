package se.kth.iv1350.hackers.view;

import se.kth.iv1350.hackers.model.PaymentObserver;

public class TotalRevenueOutput implements PaymentObserver{
    private double totalRevenue;
    
    public void updateTotal(double totalRevenue){
        this.totalRevenue = totalRevenue; 
    }
}
