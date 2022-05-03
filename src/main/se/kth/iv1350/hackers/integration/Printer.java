package se.kth.iv1350.hackers.integration;
import se.kth.iv1350.hackers.model.Receipt;

/**
 * Printer is used for all printouts from the point of sale.
 * calls method from Receipt.
 */
public class Printer {
    /**
     * Prints the receipt of the current sale. This placeholder
     * implementation prints to <code>System.out</code>
     * instead of printer.
     * 
     * @param receipt
     */
    public void printReceipt(Receipt currentReceipt){
        System.out.println(currentReceipt.receiptToString());
    }
}