package se.kth.iv1350.hackers.integration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CashRegisterTest {
    @Test
    public void testGetBalance() {
        CashRegister cashRegister = new CashRegister(100);
        
        double expResult = 100; 
        double result = cashRegister.getBalance().getAmount(); 
        
        assertEquals(expResult, result, "Amount object does not contain the specified value.");
    }
}
