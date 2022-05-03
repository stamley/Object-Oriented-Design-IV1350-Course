package sourcepackage.se.kth.iv1350.hackers.DTO;
import sourcepackage.se.kth.iv1350.hackers.util.*;

/**
 * Contains information about one particular item.
 */
public final class ItemDTO{
    private final String itemName;
    private final Amount itemPrice;
    private final Amount itemVAT;

    /**
     * Get a new instance representing a particular item.
     * 
     * @param itemName the name of the item.
     * @param itemPrice the price of the item.
     * @param vatAmount the amount of vat for an item.
     */
    public ItemDTO(String itemName, Amount itemPrice, Amount itemVAT){
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemVAT = itemVAT;
    }

    /**
     * Get the value of itemName.
     * 
     * @return the value of itemName.
     */
    public String getItemName(){
        return itemName;
    }

    /**
     * Get the value of itemPrice.
     * 
     * @return the value of itemPrice.
     */
    public Amount getItemPrice(){
        return itemPrice;
    }

    /**
     * Get the value of vatAmount.
     * 
     * @return the value of vatAmount.
     */
    public Amount getItemVAT(){
        return itemVAT;
    }
}
