package sourcepackage.se.kth.iv1350.hackers.model;
import sourcepackage.se.kth.iv1350.hackers.DTO.*;
import sourcepackage.se.kth.iv1350.hackers.util.Amount;

import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * A representation of a sale.
 */
public class Sale {
    private PaymentTotal paymentTotal;
    private HashMap <String, Item> items = new HashMap<String, Item>();
    private LocalDateTime dateAndTime;
    private Amount amountPaid;
    private Amount changeAmount;

    /**
     * Creates a new instance of sale with initial amount set to zero.
     */
    public Sale(){
        this.paymentTotal = new PaymentTotal();
        dateAndTime =  LocalDateTime.now();
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
            updateQuantityAndTotal(item);
        }
        else {
            addItemAndUpdateTotal(item);
        }
        return new SaleDTO(paymentTotal, dateAndTime, items);
    }

    /**
     * Checks if the scanned item already exist in the HashMap.
     * 
     * @param item The current item that is being added.
     * @return <code>true</code> if the item exists in the HashMap.
     * returns <code>false</code> if the item 
     */
    private boolean itemListContainsItem(Item item){
        return items.containsKey(item.getItemIdentifier());
    }

    /**
     * Updates the quantity of an already existing item and increase the total payment amount.
     * 
     * @param item The current item that is being added.
     */
    private void updateQuantityAndTotal(Item item){
        Item existingItem = items.get(item.getItemIdentifier());
        existingItem.increaseQuantity(item.getQuantity());
        items.put(existingItem.getItemIdentifier(), existingItem);
        paymentTotal.UpdatePaymentTotal(item);
    }

    /**
     * Adds a new item to the sale and update the total payment amount.
     * 
     * @param item The item that is being added.
     */
    private void addItemAndUpdateTotal(Item item){
        items.put(item.getItemIdentifier(), item);
        paymentTotal.UpdatePaymentTotal(item);
    }

     /**
     * Applies the discount to the <code>currentSale</code> object.
     * 
     * @param discount contains the discount information that shall
     * be applied to the <code>totalPrice</code> parameter.
     * @return a new updated <code>SaleDTO</code> with the applied discount
     */
    public SaleDTO applyDiscount (DiscountDTO discount){
        this.paymentTotal = this.paymentTotal * discount.getTotalDiscountPercentage();
        return new SaleDTO (this);
   } 

    /**
     * Gets the value of totalPrice.
     * @return the totalPrice.
     */
    public PaymentTotal getTotalPrice(){
        return paymentTotal;
    }

    /**
     * Get the value of HashMap items.
     * @return the HashMap items.
     */
    public HashMap<String, Item> getItems(){
        return items;
    }

    /**
     * Get the value of dateAndTime.
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
}