package se.kth.iv1350.hackers.controller;

import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import se.kth.iv1350.hackers.DTO.SaleDTO;
import se.kth.iv1350.hackers.integration.DBController;
import se.kth.iv1350.hackers.integration.IOController;
import se.kth.iv1350.hackers.util.Amount;
import se.kth.iv1350.hackers.controller.Controller;

public class ControllerTest {
    private Controller controller;
    private SaleDTO saleDTO;

    @BeforeEach
    public void setUp(){
        controller = new Controller(new IOController(), new DBController());
    }
    
    @After
    public void tearDown(){
        controller = null;
    }

    @Test
    public void addItemTest(){
        String itemIdentifier = "12345";
        Amount quantity = new Amount(5);
        saleDTO = controller.addItem(itemIdentifier, quantity);
    }

}
