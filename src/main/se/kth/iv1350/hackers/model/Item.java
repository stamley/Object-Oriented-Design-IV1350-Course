package se.kth.iv1350.hackers.model;
import se.kth.iv1350.hackers.DTO.ItemDTO;
import se.kth.iv1350.hackers.util.*;

/**
 * A representation of an item.
 */
public class Item{
    private ItemDTO itemDescription;
    private String itemIdentifier;
    private Amount itemQuantity;

    /**
     * Creates a new instance of an Item.
     * 
     * @param itemDescription The description of an item.
     */
    public Item(ItemDTO itemDescription, String itemIdentifier, Amount itemQuantity){
        this.itemDescription = itemDescription;
        this.itemIdentifier = itemIdentifier;
        this.itemQuantity = itemQuantity;
    }

    /**
     * Method to increase the quantity of an item.
     * 
     * @param otherItemQuantity the {@link Amount} that will be added the quantity.
     */
    public void increaseQuantity(Amount otherItemQuantity){
        this.itemQuantity = this.itemQuantity.increase(otherItemQuantity);
    }

    /**
     * Get the value of itemDescription.
     * @return The value of itemDescription.
     */
    public ItemDTO getItemDescription(){
        return itemDescription;
    }

    /**
     * Get the value of itemIdentifier.
     * @return The value of itemIdentifier.
     */
    public String getItemIdentifier(){
        return itemIdentifier;
    }

    /**
     * Get the value of itemQuantity
     * @return The value of itemQuantity.
     */

     public Amount getQuantity(){
         return itemQuantity;
     }


}