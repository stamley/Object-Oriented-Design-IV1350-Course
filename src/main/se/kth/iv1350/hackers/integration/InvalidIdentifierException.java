package se.kth.iv1350.hackers.integration;
/**
 * This class handles invalid identifiers. 
 */

public class InvalidIdentifierException extends Exception{
    String itemIdentifier;
    public InvalidIdentifierException(String itemIdentifier){
        super("this item identifier : " + itemIdentifier + " Does not exist");
        this.itemIdentifier = itemIdentifier;
    }
    
    public String getItemIdentifier (){
        return this.itemIdentifier;
    }
}
