package se.kth.iv1350.hackers.view;
import se.kth.iv1350.hackers.DTO.SaleDTO;
import se.kth.iv1350.hackers.controller.Controller;
import se.kth.iv1350.hackers.util.*;

/**
 * The application does not have an actual view, and this class
 * is a placeholder.
 */

public class View {
    private Controller controller;
    
    /**
     * Creates a new instance of view.
     * 
     * @param controller the class where all calls are being made.
     */
    public View(Controller controller){
        this.controller = controller;
    }
    /**
     * Fake execution from the view.
     * 
     */
    public void sampleExecution(){
        SaleDTO saleInformation;
        Amount changeAmount;

        controller.initiateSale();
        saleInformation = controller.addItem("1234", new Amount(3));
        saleInformation = controller.discountedSaleRequest(123);
        saleInformation = controller.endSale();
        
        changeAmount = controller.registerPayment(new Amount(200));
    }

   
}