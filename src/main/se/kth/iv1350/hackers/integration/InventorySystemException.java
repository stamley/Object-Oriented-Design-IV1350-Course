package se.kth.iv1350.hackers.integration;
/**
 * This exception is thrown when the Inventory System is not functioning, for example when the server is down.
 */
public class InventorySystemException extends RuntimeException {
    
    public InventorySystemException (String message){
        super(message);
    }   
}
