package se.kth.iv1350.hackers.integration;
/**
 * Thrown when an item itentifier is invalid. 
 */

public class InvalidIdentifierException extends Exception{

    /**
     * Creates a new instance with the specified itemidentifier that caused the exception. 
     * @param itemIdentifier The specified itendifier.
     */
    String itemIdentifier;
    public InvalidIdentifierException(String itemIdentifier){
        super("This item identifier: " + itemIdentifier + " does not exist");
        this.itemIdentifier = itemIdentifier;
    }
    
    public String getItemIdentifier (){
        return this.itemIdentifier;
    }
}
