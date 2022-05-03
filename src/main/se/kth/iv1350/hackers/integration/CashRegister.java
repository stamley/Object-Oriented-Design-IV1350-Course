package se.kth.iv1350.hackers.integration;
import se.kth.iv1350.hackers.util.*;

/**
 * A representation of a cash register. 
 */

public class CashRegister {
    private Amount balance;

    /**
     * Creates a new instance of CashRegister with an initial balance of zero.
     */
    CashRegister(double initialBalance){
        this.balance = new Amount(initialBalance);
    }

    /**
     * Get the value of balance.
     * 
     * @returns the value of balance.
     */
     public Amount getBalance(){
         return this.balance;
     }

    /**
    * Sets the balance of the CashRegister.
    *
    * @param balance The desired amount to set balance to.
    * @return The new <code>Amount</code>.
    */
    public Amount setBalance (double balance){
         return this.balance.setAmount(balance);
    }

    /**
     * Adds payment to cash register balance.
     * 
     * @param payment <code>Amount</code> to add.
     */
    public void addPayment (Amount payment){
       this.balance.increase(payment);
    }
     
}
