package se.kth.iv1350.hackers.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.hackers.util.Amount;




public class CashRegisterTest {
    @Test
    public void testAddPayment() {

    }

    @Test
    public void testGetBalance() {
        CashRegister cashRegister = new CashRegister(100);
        
        double expResult = 100; 
        double result = cashRegister.getBalance().getAmount(); 
        
        assertEquals(expResult, result);
        fail("Amount object does not contain the specified value.");
    }

    @Test
    public void testSetBalance() {
        
    }
}
