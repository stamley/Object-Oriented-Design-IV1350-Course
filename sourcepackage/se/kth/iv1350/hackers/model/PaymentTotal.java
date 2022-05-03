package sourcepackage.se.kth.iv1350.hackers.model;
import sourcepackage.se.kth.iv1350.hackers.util.Amount;

/**
 * A representation of the total amount to be paid including VAT.
 */

public class PaymentTotal {
    private Amount total;
    private Amount totalIncludingVAT;

    /**
     * Creates a new instance of payment total and totalVAT 
     * with an initial amount set to zero.
     */
    PaymentTotal(){
        Amount total = new Amount(0);
        Amount totalIncludingVAT = new Amount(0);
    }

    /**
     * Updates payment total and with and without VAT.
     * 
     * @param item The item that is being scanned.
     */
    public void UpdatePayment(Item item){
        if (item == null){
            return;
        }
        Amount itemQuantity = item.getQuantity();
        Amount itemPrice = item.getItemDescription().getItemPrice();
        Amount itemVAT = item.getItemDescription().getItemVAT();

        this.total = total.increase(calculateTotal(itemQuantity, itemPrice));
        this.totalIncludingVAT = this.totalIncludingVAT.increase(calculateTotalIncludingVAT
                                                        (itemVAT, itemQuantity, itemPrice));
    }

    /**
     * Calculates the total cost of the item(s).
     * 
     * @param itemQuantity The quantity of the specific item.
     * @param itemPrice The price of one item.
     * @return The product of itemQuantity and itemPrice.
     */
    private Amount calculateTotal(Amount itemQuantity, Amount itemPrice){
       return itemQuantity.multiply(itemPrice);
    }

    /**
     * Calculates the total cost of the item(s) including VAT.
     * 
     * @param itemVAT The VAT amount for a specific item.
     * Assuming the VAT of an item is 5% the total is multiplied 1 + the VAT percentage.
     * @param itemQuantity The quantity of the specific item.
     * @param itemPrice The price of one item.
     * @return The product of the total cost of the item(s) and item VAT amount.
     */
    private Amount calculateTotalIncludingVAT(Amount itemVAT, Amount itemQuantity, Amount itemPrice){
        return itemVAT.multiply(calculateTotal(itemQuantity, itemPrice));
    }

    /**
     * Gets the value of totalIncludingVAT.
     * 
     * @return The value of totalIncludingVAT.
     */
    public Amount getTotalIncludingVAT(){
        return totalIncludingVAT;
    }

    /**
     * Gets the value of total.
     * 
     * @return the value of total.
     */
    public Amount getTotal(){
        return total;
    }
}
