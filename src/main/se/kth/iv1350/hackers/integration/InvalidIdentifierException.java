package se.kth.iv1350.hackers.integration;

public class InvalidIdentifierException extends Exception{
    public InvalidIdentifierException(String errorMessage){
        super(errorMessage);
    }
}
