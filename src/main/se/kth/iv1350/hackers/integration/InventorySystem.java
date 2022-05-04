package se.kth.iv1350.hackers.integration;
import java.util.HashMap;

import se.kth.iv1350.hackers.DTO.ItemDTO;
import se.kth.iv1350.hackers.DTO.SaleDTO;
import se.kth.iv1350.hackers.model.Item;
import se.kth.iv1350.hackers.util.Amount;


/**
 * A representation of a inventory system.
 */
public class InventorySystem {
    private HashMap <String, Item> itemList = new HashMap<String, Item>();
    /**
     * package private constructor-method 
     */
    InventorySystem(){

    }

    /**
     * Checks if the searched item identifier exists in the database.
     * 
     * @param itemIdentifier The item that is being scanned.
     * @return If the item exists in the method will return <code>true</code>
     * else if will return <code>null</code>.
     */
    private boolean itemExists(String itemIdentifier){
        System.out.println ("InventorySystem: Checks if identifier: " + itemIdentifier + " exists in the database");
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
        if (itemExists(itemIdentifier)){
            System.out.println ("InventorySystem: Fetching item information");
            return true;
        }

        else{ 
            System.out.println("InventorySystem: Invalid item identifier");
            return false;
        }
    }

    /**
     * Gets the corresponding HashMap Item.
     * 
     * @param itemIdentifier The value bound to a particular Item.
     * @param quantity The quantity of a particular Item.
     * @return
     */
    public Item getItem(String itemIdentifier, Amount quantity){
        Item fetchedItem = new Item(itemList.get(itemIdentifier).getItemDescription(), 
            itemIdentifier, quantity); 
        System.out.println("InventorySystem: Fetching item from the database");
        return fetchedItem;
    }

    /**
     * Updates the external inventory system 
     */
    public void updateInventorySystem (SaleDTO saleinformation){
        System.out.println("InventorySystem: Updating Inventory System with the sale information");
    }

    /**
     * Adds item to the hashmap representing the external inventory system.
     * 
     * @param item Item to be added.
     */
    public void addItemToInventorySystem(Item item){
        this.itemList.put("128886678", item);
        
    }
}
