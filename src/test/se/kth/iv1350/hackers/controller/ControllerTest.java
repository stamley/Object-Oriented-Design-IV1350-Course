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

    @Test
    public void testAddItem(){
        /*
        controller.initiateSale();
        Sale currentSale = new Sale();

        String itemName = "Apple";
        Amount costOfItem = new Amount(2);
        Amount VATOfItem = new Amount(20);

        Item itemToAdd = new Item(new ItemDTO(itemName, costOfItem, VATOfItem),
        "128886678",new Amount(2));
         
        controller.addItemToInventorySystem(itemToAdd);

        String identifier = "128886678";
        Amount quantity = new Amount(5);
        
        SaleDTO saleDTO1 = controller.addItem(identifier, quantity);
        SaleDTO saleDTO2 = currentSale.addItem(itemToAdd);

        try{
            SaleDTO saleDTO1 = controller.addItem(identifier, quantity);
            SaleDTO saleDTO2 = currentSale.addItem(itemToAdd);
            boolean expectedResult = true;
            boolean actualResult = saleDTO1.equals(saleDTO2);
            fail("Could add a non exisiting item");
        }
        catch(OperationFailedException operationFailed){
            
        }*/
    }

    @Test
    public void testRequestItemInfo(){

        OperationFailedException thrown = assertThrows("Expected requested item info to throw, but it didn't.",
        OperationFailedException.class,() -> controller.requestItemInfo("1337"));

        assertTrue(thrown.getMessage().contains("Operation Failed"));
    }
}
