package se.kth.iv1350.hackers.controller;

/**
 * Thrown when an operation called from the view fails for an unknown reason.
 */

public class OperationFailedException 
extends Exception {

    /**
     * Creates a new instance with the root cause and message
     * 
     * @param message   The exception message.
     * @param cause     The rootcause exception that caused this exception.
     */
    public OperationFailedException (String message, Exception cause ){
        super(message, cause);
    }

    /**
     * Creates a new instance with message
     * 
     * @param message The exception message.
     */
    public OperationFailedException (String message){
        super (message);
    }
}
