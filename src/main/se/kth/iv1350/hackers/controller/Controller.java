package se.kth.iv1350.hackers.controller;

import se.kth.iv1350.hackers.DTO.SaleDTO;
import se.kth.iv1350.hackers.integration.*;
import se.kth.iv1350.hackers.model.*;
import se.kth.iv1350.hackers.util.Amount;
import se.kth.iv1350.hackers.util.LogHandler;
import java.util.ArrayList;

public class Controller {
    private IOController ioController;
    private DBController dbController; 
    private Sale currentSale;
    private Receipt currentReceipt;
    private ArrayList<PaymentObserver> paymentObserversList = new ArrayList<PaymentObserver>();

    /**
     * Creates a new instance of controller.
     * 
     * @param ioController used to get all classes that handles IO systems calls.
     * @param dbController used to get all classs that handles database calls. 
     */
    public Controller(IOController ioController, DBController dbController){
        this.ioController = ioController;
        this.dbController = dbController;
    }

    /**
     * Starts a new sale.
     */
     public void initiateSale(){
        this.currentSale = new Sale();
        System.out.println("\n\n\n-----------\nInitiated sale");
     }
    
    /**
    * Fetches information for a particular item.
    *
    * @param identifier The itentifier that is being scanned.
    * @return information about the specified item
    * @throws OperationFailedException throws new, more fitting exceptions to the view 
    */
    public boolean requestItemInfo(String identifier) throws OperationFailedException{
        boolean itemInfoFound = false;
        try {
          itemInfoFound =  dbController.requestItemInfo(identifier);
        }
        catch(InvalidIdentifierException e) {
           throw new OperationFailedException ("User Interface - Operation Failed, invalid identifier: " + e.getItemIdentifier(), e);
        }
       
        return itemInfoFound;
      
    }

    /**
     * Adds an item to the current sale. The method will first check if the corresponding
     * identifier exists in the inventory system.
     * 
     * @param identifier The identifier scanned by the cashier.
     * @param quantity The quantity specified by the cashier.
     * @return The current  sale with the new item added if the <code>identifier</code> was valid, 
     * <code>null</code> if the identifier was invalid.
     * @throws OperationFailedException
     */
    public SaleDTO addItem(String identifier, Amount quantity) throws OperationFailedException{
        if(requestItemInfo(identifier)){
            Item item = dbController.getItem(identifier, quantity);
            return currentSale.addItem(item);
        }
        else{
            return null;
        }
    }
    /**
     * Requests discount from DBHandler and this discount is applied to the sale.
     * 
     * @param customerID ID of customer proving eligibility of discount..
     * @return An object of type sale DTO.
     */
    public SaleDTO discountedSaleRequest(int customerID){
        System.out.println("Controller: Requesting discount from database");
        return currentSale.applyDiscount(dbController.discountRequest(customerID));
    }

    /**
     * Ends the sale, creates and prints receipt and updates external systems.
     * 
     * @return The final version of SaleDTO containing all sale information.
     */
    public SaleDTO endSale(){
        //return currentSale.endSale();
        SaleDTO endedSaleDTO = currentSale.endSale();
        currentReceipt = new Receipt(endedSaleDTO);
        dbController.updateExternalSystems(endedSaleDTO);
        System.out.println("Controller: Ends sale\nPrinting receipt...\n");
        printReceipt();
        return endedSaleDTO;
    }

    /**
     * Registers the customer payment which will update the current sale.
     * 
     * @param payment Customer payment.
     * @return Change of sale as an amount.
     */
    public Amount registerPayment(Amount payment){
        return currentSale.registerPayment(payment);
    }

    /**
     * Logs current sale in sale log
     * 
     * @param saleInformation SaleDTO of current sale.
     */
    public void logSale(SaleDTO saleInformation){
        ioController.logSale(saleInformation);
    }

    /**
     * Prints the current receipt.
     */

    public void printReceipt(){
        ioController.printReceipt(currentReceipt);
    }

    /**
     * Adds item to external inventory system
     * 
     * @param item Item to be added.
     */
    public void addItemToInventorySystem(Item item){
        dbController.addItemToInventorySystem(item);
    }

    /**
     * Adds payment observer to the current sale;
     * @param paymentObserver
     */

    public void addPaymentObservers(){
        currentSale.addPaymentObserver(paymentObserversList);
    }

    /**
     * Adds payment observer to the payment observer list of the controller.
     * @param paymentObserver
     */

    public void addPaymentObserversToList(PaymentObserver paymentObserver){
        paymentObserversList.add(paymentObserver);
    }
}
