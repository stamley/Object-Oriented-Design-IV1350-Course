package sourcepackage.se.kth.iv1350.hackers.DTO;
import sourcepackage.se.kth.iv1350.hackers.model.*;
import sourcepackage.se.kth.iv1350.hackers.util.*;
import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * Contains information about one particular sale.
 */
public final class SaleDTO{
    private final PaymentTotal paymentTotal;
    private final LocalDateTime localDateTime;
    private HashMap <String, Item> items = new HashMap<String, Item>();
    private Amount amountPaid;
    private Amount changeAmount; 

    /**
     * Creates a new instance representing a particular sale.
     * 
     * @param paymentTotal  The sale's total running price.
     * @param dateAndTime   The current date and time.
     * @param items         The list containing all items.
     * @param amountPaid    The amount paid by the customer.
     * @param changeAmount  The change which should be given back to the customer.  
     */

    /**
     * Create a new instance representing a particular sale.
     * @param currentSale
     */
    public SaleDTO(Sale currentSale){
        this.paymentTotal = currentSale.getTotalPrice();
        this.localDateTime = currentSale.getLocalDateTime();
        this.items = currentSale.getItems();
        this.amountPaid = currentSale.getAmountPaid();
        this.changeAmount = currentSale.getChangeAmount();
    }
    
    /**
     * Creates a new instance representing a particular sale without any information
     * regarding the actual payment from the customer.
     * 
     * @param paymentTotal The sale's total running price.
     * @param dateAndTime  The current date and time.
     * @param items        The list containing all items.
     */
    public SaleDTO(PaymentTotal paymentTotal, LocalDateTime dateAndTime,
    HashMap<String,Item> items){
        this.paymentTotal = paymentTotal;
        this.localDateTime = dateAndTime;
        this.items = items;
    }
  
    /**
     * Get the value of totalRunningPrice.
     * 
     * @return the value of totalRunningPrice.
     */
    public PaymentTotal getPaymentTotal(){
        return paymentTotal;
    }

    /**
     * Get the value of dateAndTime.
     * 
     * @return the value of dateAndTime.
     */
    public LocalDateTime getDateAndTime(){
        return dateAndTime;
    }

    /**
     * Get the value of amountPaid.
     * 
     * @return the value of amountPaid.
     */
    public Amount getAmountPaid(){
        return amountPaid;
    }

    /**
     * Get the value of changeAmount.
     * 
     * @return the value of changeAmount.
     */
    public Amount getChangeAmount(){
        return changeAmount;
    }

    /**
     * Get the value of items.
     *
     * @return the value of items.
     */
    public HashMap <String, Item> getItemList(){
        return items;
    }
    
}