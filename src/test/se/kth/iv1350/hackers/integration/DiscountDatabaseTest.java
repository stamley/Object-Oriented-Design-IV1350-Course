package se.kth.iv1350.hackers.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.hackers.DTO.DiscountDTO;
import se.kth.iv1350.hackers.util.Amount;


public class DiscountDatabaseTest {
    private DiscountDatabase discountDatabase;

    @BeforeEach
    public void setupClass(){
        DiscountDatabase discountDatabase = new DiscountDatabase();
    }


    @Test
    public void testDiscountRequest() {
        Amount amount = new Amount(0.1);
        String typeOfDiscount = "PlaceholderTypeOfDiscount";

        DiscountDTO discountDTO = new DiscountDTO(amount, typeOfDiscount);
        DiscountDTO otherDiscountDTO = discountDatabase.discountRequest(100);
        
        boolean expResult = true;
        boolean result = discountDTO.equals(otherDiscountDTO);
        
        assertEquals(expResult, result, "DiscountDTO with the same states are not equal.");
    }

    @Test
    public void testInvalidDiscount() {
        double result = discountDatabase.fetchDiscountAmountFromDatabase(100).getAmount();
        double validDisocunt = 1;
        assertTrue(result < validDisocunt , "The discount is not valid.");
    }

    @Test
    public void testFetchTypeOfDiscountFromDatabase() {
        String expResult = "PlaceholderTypeOfDiscount";
        String result = discountDatabase.fetchTypeOfDiscountFromDatabase(100);
        assertEquals(expResult, result,"The method does not return the expected string.");
    }
}
