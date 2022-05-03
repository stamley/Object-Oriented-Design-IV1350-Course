package se.kth.iv1350.hackers.util;

/**
 * Represents an amount of money.
 */
public class Amount{
    private final double amount;

    /**
     * Creates an instance of Amount.
     * @param amount the amount represented by the newly created instance.
     */

    public Amount(double amount){
        this.amount = amount;
    }

    /**
     * Method to increase amount with a specified <code>Amount</code>.
     * 
     * @param other The specified <code>Amount</code>.
     * @return The sum of the previous <code>Amount</code> plus other <code>Amount</code>.
     */
    public Amount increase(Amount other){
        return new Amount(this.amount + other.amount);
    }

    /**
     * Method to decrease amount with a specified <code>Amount</code>.
     * @param other The specified <code>Amount</code>.
     * @return The differenace between the previous <code>Amount</code> and the other <code>Amount</code>.
     */
    public Amount decrease(Amount other){
        return new Amount(this.amount - other.amount);
    }

    /**
     * Method to multiply two different amounts.
     * @param other The specified amount.
     * @return The product between the previous <code>Amount</code> and the other <code>Amount</code>.
     */
    public Amount multiply(Amount other){
        return new Amount(this.amount * other.amount);
    }

    /**
     * Get the value of amount.
     * 
     * @return the value of amount.
     */
    public double getAmount(){
        return amount;
    }

    /**
     * Set the value of amount.
     * 
     * @param amount The new amount for <code>Amount</code>.
     * @return The updated <code>Amount</code>.
     */
    public Amount setAmount(double amount){
        return new Amount(amount);
    }

    @Override
    public String toString() {
        return this.amount + " ";
    }

    /**
     * Compares if two instances of <code>Amount</code> represent the same amount.
     * 
     * @param other The <code>Amount</code> to be compared with this amount.
     * @return <code>true</code> if the two objects represent the same amount.
     * returns <code>false</code> if the two objects represent different amounts.
     */
    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Amount)) {
            return false;
        }
        Amount otherAmount = (Amount)other;
        return amount == otherAmount.amount;
    }
}