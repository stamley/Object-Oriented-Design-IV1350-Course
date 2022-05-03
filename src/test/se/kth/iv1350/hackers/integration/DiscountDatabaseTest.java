package se.kth.iv1350.hackers.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DiscountDatabaseTest {
    @Test
    public void testDiscountRequest() {

    }

    @Test
    public void testInvalidDiscount() {
        DiscountDatabase discountDatabase = new DiscountDatabase();
        double result = discountDatabase.fetchDiscountAmountFromDatabase(100).getAmount();
        double validDisocunt = 1;
        assertTrue(result < validDisocunt , "The discount is not valid.");
    }

    @Test
    public void testFetchTypeOfDiscountFromDatabase() {

    }
}
