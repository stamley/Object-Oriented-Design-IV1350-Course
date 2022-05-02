package sourcepackage.se.kth.iv1350.hackers.model;
import sourcepackage.se.kth.iv1350.hackers.util.Amount;

/**
 * A representation of the total amount to be paid including VAT.
 */

public class PaymentTotal {
    private Amount total;
    private Amount totalVAT;
    private Amount totalDiscounted;

    /**
     * Creates a new instance of payment total and totalVAT 
     * with initial amount set to zero.
     */
    PaymentTotal(){
        Amount total = new Amount(0);
        Amount totalVAT = new Amount(0);
    }

    /**
     * Updates payment total and with and without VAT.
     * 
     * @param item The item that is being scanned.
     */
    public void UpdatePaymentTotal(Item item){
        /**
         * EXCEPTION FOR SEMINAR 4.
         */
        if (item == null){
            return;
        }
        Amount itemQuantity = item.getQuantity();
        Amount itemPrice = item.getItemDescription().getItemPrice();
        Amount itemVAT = item.getItemDescription().getItemVAT();

        this.total = this.total.increase(itemQuantity.multiply(itemPrice));

        // this.totalVAT = this.totalVAT.increase(itemQuantity.multiply(itemVAT));
    }

    /**
     * Gets the value of totalIncludingVAT.
     * 
     * @return The value of totalIncludingVAT.
     */
    public Amount getTotalIncludingVAT(){
        return totalVAT;
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
