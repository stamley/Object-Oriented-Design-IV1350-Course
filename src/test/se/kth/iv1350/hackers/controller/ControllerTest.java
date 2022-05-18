package se.kth.iv1350.hackers.controller;
import se.kth.iv1350.hackers.integration.*;
import se.kth.iv1350.hackers.model.Item;
import se.kth.iv1350.hackers.model.Sale;
import se.kth.iv1350.hackers.util.Amount;
import se.kth.iv1350.hackers.DTO.ItemDTO;
import se.kth.iv1350.hackers.DTO.SaleDTO;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ControllerTest{
    private Controller controller;

    @Before
    public void setup(){
        controller = new Controller(new IOController(), new DBController());
    }

    @After
    public void tearDown(){
        controller = null;
    }

    /**
     * Tests if exception is thrown by comparing the message in the exception with expected message.
     */
    @Test
    public void testOperationFailedException(){
        OperationFailedException thrown = assertThrows("Expected requested item info to throw, but it didn't.",
        OperationFailedException.class,() -> controller.requestItemInfo("1337"));

        assertTrue(thrown.getMessage().contains("Operation Failed"));
    }
}
