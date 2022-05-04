package se.kth.iv1350.hackers.controller;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.hackers.DTO.*;
import se.kth.iv1350.hackers.integration.*;
import se.kth.iv1350.hackers.util.Amount;
import se.kth.iv1350.hackers.model.*;


public class ControllerTest {
    private Controller controller;
    private Sale currentSale;
    private SaleDTO saleDTO;

    @BeforeEach
    public void setUp(){
        controller = new Controller(new IOController(), new DBController());
        currentSale = new Sale();
        saleDTO = new SaleDTO(currentSale);
    }
    
    @AfterEach
    public void tearDown(){
        controller = null;
        saleDTO = null;
    }

    @Test
    public void addItemTest(){

        String itemName = "Tomato";
        Amount costOfItem = new Amount(5);
        Amount VATOfItem = new Amount(20);
        Item itemToAdd = new Item(new ItemDTO(itemName, costOfItem, VATOfItem), "128886678", new Amount(2));
        
        Amount quantity = new Amount (5);
        /*
        controller.addItemToInventorySystem(itemToAdd);
        saleDTO = controller.addItem("128886678", quantity);
        */

        boolean expectedResult = true;
        /*String first = saleDTO.getItemList().get("128886678").getItemDescription().getItemName();
        String second = itemToAdd.getItemIdentifier();
        boolean result = first.equals(second);
        
        assertEquals(expectedResult, result, "");*/
    }

}
