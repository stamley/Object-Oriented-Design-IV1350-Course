package sourcepackage.se.kth.iv1350.hackers.integration;
import sourcepackage.se.kth.iv1350.hackers.model.Item;
import sourcepackage.se.kth.iv1350.hackers.DTO.ItemDTO;
import sourcepackage.se.kth.iv1350.hackers.DTO.SaleDTO;
import sourcepackage.se.kth.iv1350.hackers.util.Amount;
import java.util.HashMap;


/**
 * A representation of a inventory system.
 */
public class InventorySystem {
    private HashMap <String, ItemDTO> itemList = new HashMap<String, ItemDTO>();

    /**
     * Checks if the searched item identifier exists in the database.
     * 
     * @param itemIdentifier The item that is being scanned.
     * @return If the item exists in the method will return <code>true</code>
     * else if will return <code>null</code>.
     */
    private boolean itemExists(String itemIdentifier){
        return itemList.containsKey(itemIdentifier);
    }

    /**
     * Fetches information for a particular item.
     * 
     * @param identifier The item that is being scanned.
     * @return If the item exists the method will return the coresponding item,
     * if it does not exist function returns <code>null</code>.
     */
    public boolean requestItemInfo(String itemIdentifier){
        if (itemExists(itemIdentifier))
        {
            return true;
        }
        return false;
    }

    /**
     * Gets the corresponding HashMap Item.
     * 
     * @param itemIdentifier The value bound to a particular Item.
     * @param quantity The quantity of a particular Item.
     * @return
     */
    public Item getItem(String itemIdentifier, Amount quantity){
        return new Item(itemList.get(itemIdentifier), itemIdentifier, quantity); 
    }

    /**
     * Updates the external inventory system 
     */
    public void updateInventorySystem (SaleDTO saleinformation){
        
    }
}
