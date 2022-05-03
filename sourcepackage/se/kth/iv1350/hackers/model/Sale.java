package sourcepackage.se.kth.iv1350.hackers.model;
import sourcepackage.se.kth.iv1350.hackers.DTO.*;
import sourcepackage.se.kth.iv1350.hackers.util.Amount;

import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * A representation of a sale.
 */
public class Sale {
    private TotalPrice totalPrice;
    private HashMap <String, Item> items = new HashMap<String, Item>();
    private LocalDateTime dateAndTime;
    private Amount amountPaid;
    private Amount changeAmount;

    /**
     * Creates a new instance of sale with initial amount set to zero.
     */
    public Sale(){
        this.totalPrice = new TotalPrice();
        this.items = new HashMap<String, Item>();
        this.dateAndTime =  LocalDateTime.now();
        this.amountPaid = new Amount(0);
        this.changeAmount = new Amount(0);
    }

    /**
     * Search if the item that is being added exists inside the <code>items</code> object.
     * If the item already exists the method will call a nesting method to update the quantity
     * and total payment amount.
     * If the item does not not exists the method will call a nesting method to add the item
     * and update the total payment amount.
     * 
     * @param item The current item that is being added.
     */
    public SaleDTO addItem(Item item){
        if (itemListContainsItem(item)){
            // updateQuantityAndTotal(item);
            this.updateQuantity(item);
            this.updateTotal(item);

        }
        else {
            this.addItemToList(item);
            this.updateTotal(item);
        }
        return new SaleDTO(this);
    }

    /**
     * Checks if the scanned item already exist in the HashMap.
     * @param item The current item that is being added.
     * @return <code>true</code> if the item exists in the HashMap.
     * returns <code>false</code> if the item 
     */
    private boolean itemListContainsItem(Item item){
        return items.containsKey(item.getItemIdentifier());
    }

    /**
     * Updates the quantity of an item.
     * 
     * @param item The current item that is being added.
     */
    private void updateQuantity (Item item){
        Item existingItem = items.get(item.getItemIdentifier());
        existingItem.increaseQuantity(item.getQuantity());
        addItemToList(existingItem);
        updateTotal(item);
    }

    /**
     * Adds a new item to the sale
     * 
    * @param item The item that is being added.
    */
    private void addItemToList (Item item){
        items.put(item.getItemIdentifier(), item);
        updateTotal(item);

    }
    /**
     * updates the total with the corresponding price of that item
     * 
     * @param item
     */
    private void updateTotal (Item item){
        totalPrice.UpdatePrice(item);
    }

     /**
     * Applies the discount to the <code>currentSale</code> object.
     * 
     * @param discount contains the discount information that shall
     * be applied to the <code>totalPrice</code> parameter.
     * @return a new updated <code>SaleDTO</code> with the applied discount
     */
    public SaleDTO applyDiscount (DiscountDTO discount){
        totalPrice.setTotalDiscountedIncludingVAT(totalPrice.getTotalIncludingVAT().multiply(
            discount.getTotalDiscountPercentage()));
        return new SaleDTO (this);
   }

    /**
    * Finalizes the sale. 
    *
    * @param currentSale The current sale that is being processed.
    * @return The final version of SaleDTO containing all the sale information.
    */
   public SaleDTO endSale(){
       return new SaleDTO(this);
   }

    /**
     * Gets the value of totalPrice.
     * 
     * @return the totalPrice.
     */
    public TotalPrice getTotalPrice(){
        return totalPrice;
    }

    /**
     * Get the value of HashMap items.
     * 
     * @return the HashMap items.
     */
    public HashMap<String, Item> getItems(){
        return items;
    }

    /**
     * Get the value of dateAndTime.
     * 
     * @return the dateAndTime value.
     */
    public LocalDateTime getLocalDateTime(){
        return this.dateAndTime;
    }

    /**
     * Get the value of amountPaid.
     * 
     * @return the paid amount.
     */
    public Amount getAmountPaid(){
        return this.amountPaid;
    }

    /**
     * Get the value of changeAmount.
     * 
     * @return the changeAmount.
     */
    public Amount getChangeAmount(){
        return this.changeAmount;
    } 

    public SaleDTO registerPayment (Amount payment){
        amountPaid = payment;
        changeAmount = totalPrice.getTotalDiscountedIncludingVAT().decrease(amountPaid);
        return new SaleDTO (this);
    }
}