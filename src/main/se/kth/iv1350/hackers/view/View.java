package se.kth.iv1350.hackers.view;
import se.kth.iv1350.hackers.DTO.ItemDTO;
import se.kth.iv1350.hackers.DTO.SaleDTO;
import se.kth.iv1350.hackers.controller.Controller;
import se.kth.iv1350.hackers.model.Item;
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

        ItemDTO tomatDTO = new ItemDTO("Tomat", new Amount(5), new Amount (3));
        Item tomat = new Item (tomatDTO, "238886679", new Amount(1.0));
        controller.addItemToInventorySystem(tomat);

        controller.initiateSale();
        
        saleInformation = controller.addItem("128886678", new Amount(3));
        saleInformation = controller.discountedSaleRequest(123);
        changeAmount = controller.registerPayment(new Amount(200));
        saleInformation = controller.endSale();
        controller.logSale(saleInformation);
        
    }

   
}