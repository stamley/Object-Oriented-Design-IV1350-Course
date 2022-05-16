package se.kth.iv1350.hackers.view;
import se.kth.iv1350.hackers.DTO.ItemDTO;
import se.kth.iv1350.hackers.DTO.SaleDTO;
import se.kth.iv1350.hackers.controller.Controller;
import se.kth.iv1350.hackers.controller.OperationFailedException;
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
     * @throws OperationFailedException
     * 
     */
    public void sampleExecution() throws OperationFailedException{
        SaleDTO saleInformation;
        Amount changeAmount;

        ItemDTO tomatDTO = new ItemDTO("Tomat", new Amount(3), new Amount (1.2));
        Item tomat = new Item (tomatDTO, "238886679", new Amount(1.0));
        controller.addItemToInventorySystem(tomat);

        ItemDTO bananDTO = new ItemDTO("Banan", new Amount(3), new Amount (1.2));
        Item banan = new Item (bananDTO, "1212", new Amount(1.0));
        controller.addItemToInventorySystem(banan);


        controller.initiateSale();
        try {
            saleInformation = controller.addItem("128886678", new Amount(5));
        }
        catch (OperationFailedException e){
            System.out.println (e);
        }
        saleInformation = controller.addItem("1212", new Amount(5));
        saleInformation = controller.discountedSaleRequest(123);
        changeAmount = controller.registerPayment(new Amount(100));
        saleInformation = controller.endSale();
        controller.logSale(saleInformation);

        }
        
    }

   
