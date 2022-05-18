package se.kth.iv1350.hackers.integration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.DynAnyPackage.Invalid;

import se.kth.iv1350.hackers.DTO.ItemDTO;
import se.kth.iv1350.hackers.model.Item;
import se.kth.iv1350.hackers.util.Amount;

public class InventorySystemTest {
    private InventorySystem inventorySystem;

    @Before
    public void setup(){
        inventorySystem = new InventorySystem();
    }

    @After
    public void tearDown(){
        inventorySystem = null;
    }


    @Test
    public void testRequestItemInfo(){
        InvalidIdentifierException thrown = assertThrows("Expected requested item info to throw, but it didn't.",
        InvalidIdentifierException.class,() -> inventorySystem.requestItemInfo("text"));

        assertTrue(thrown.getMessage().contains("text does not exist"));
    }

    @Test
    public void testRequestItemInfoSuccesful(){
        String itemName = "Apple";
        Amount costOfItem = new Amount(2);
        Amount VATOfItem = new Amount(20);

        Item itemToAdd = new Item(new ItemDTO(itemName, costOfItem, VATOfItem),
        "128886678",new Amount(2));
        
        inventorySystem.addItemToInventorySystem(itemToAdd);

        try{
            inventorySystem.requestItemInfo("128886678");
        }
        catch(InvalidIdentifierException exc){
            fail("Exception is thrown");
            exc.printStackTrace();
        }
    }

    @Test
    public void testRequestItemInfoInventorySystemException(){
        InventorySystemException thrown = assertThrows("Expected requested item info to throw, but it didn't.",
        InventorySystemException.class,() -> inventorySystem.requestItemInfo("1212"));

        assertTrue(thrown.getMessage().contains("The database is not available"));
    }
}