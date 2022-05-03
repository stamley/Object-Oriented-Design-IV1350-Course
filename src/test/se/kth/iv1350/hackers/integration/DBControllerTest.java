package se.kth.iv1350.hackers.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.hackers.DTO.DiscountDTO;
import se.kth.iv1350.hackers.util.Amount;

public class DBControllerTest {
    private DBController dbController = new DBController();

    @Test
    public void testDiscountRequest() {
        Amount amount = new Amount(0.1);
        String typeOfDiscount = "PlaceholderTypeOfDiscount";

        DiscountDTO discountDTO = new DiscountDTO(amount, typeOfDiscount);
        DiscountDTO otherDiscountDTO = dbController.discountRequest(100);

        boolean expResult = true;
        boolean result = discountDTO.equals(otherDiscountDTO);
        
        assertEquals(expResult, result, "DiscountDTO with the same states are not equal.");
        
    }

    @Test
    public void testGetItem() {

    }

    @Test
    public void testRequestItemInfo() {

    }

    @Test
    public void testUpdateExternalSystems() {

    }
}
