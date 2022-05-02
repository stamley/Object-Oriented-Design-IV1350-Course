package sourcepackage.se.kth.iv1350.hackers.controller;
import sourcepackage.se.kth.iv1350.hackers.integration.*;
import sourcepackage.se.kth.iv1350.hackers.model.Sale;
import sourcepackage.se.kth.iv1350.hackers.model.Item;
import sourcepackage.se.kth.iv1350.hackers.integration.InventorySystem;;
import sourcepackage.se.kth.iv1350.hackers.util.Amount;
import sourcepackage.se.kth.iv1350.hackers.DTO.SaleDTO;

public class Controller {

    private IOController ioController;
    private DBController dbController;
    private Sale currentSale;

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
     }
    
    /**
    * Fetches information for a particular item.
    *
    * @param identifier The item that is being scanned.
    */
    public boolean requestItemInfo(String identifier){
       return dbController.requestItemInfo(identifier);
    }

    /**
     * Adds an item to the current sale. The method will first check if the corresponding
     * identifier exists in the inventory system.
     * 
     * @param identifier The identifier scanned by the cashier.
     * @param quantity The quantity specified by the cashier.
     */
    public SaleDTO addItem(String identifier, Amount quantity){
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
        return currentSale.applyDiscount(dbController.discountRequest(customerID));
    }
 
}
