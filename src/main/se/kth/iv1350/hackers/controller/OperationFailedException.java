package se.kth.iv1350.hackers.controller;

public class OperationFailedException 
extends Exception {
    public OperationFailedException (String message, Throwable cause ){
        super(message, cause);
    }
    public OperationFailedException (String message){
        super (message);
    }
}
