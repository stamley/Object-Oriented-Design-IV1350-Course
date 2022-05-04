package se.kth.iv1350.hackers.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.hackers.DTO.ItemDTO;
import se.kth.iv1350.hackers.DTO.SaleDTO;
import se.kth.iv1350.hackers.util.Amount;

public class SaleTest {
    private Sale currentSale;
    private SaleDTO saleDTO;

    @BeforeEach
    public void setUp(){
        currentSale = new Sale();
        saleDTO = new SaleDTO(currentSale);
    }

    @AfterEach
    public void tearDown(){
        currentSale = null;
        saleDTO = null;
    }

    @Test
    public void testAddItem() {
        String itemName = "Apple";
        Amount costOfItem = new Amount(2);
        Amount VATOfItem = new Amount(20);

        Item itemToAdd = new Item(new ItemDTO(itemName, costOfItem, VATOfItem),
         "1234",new Amount(2));
        
        saleDTO = currentSale.addItem(itemToAdd);

        boolean expResult = true;
        boolean result = saleDTO.getItemList().get("1234").equals(itemToAdd);

        assertEquals(expResult, result,
             "Item in list that was added does not equal the same item that was added.");
    }

    @Test
    public void testEndSale() {
        boolean expResult = true;
        boolean result = saleDTO.equals(currentSale.endSale()); 
        
        assertEquals(result, expResult, 
            "The ended saleDTO is not of the same state as the initiated saleDTO.");
    }

    @Test
    public void testGetItems() {
        boolean expResult = true;
        boolean result = currentSale.getItems().isEmpty();

        assertEquals(expResult, result, "Items is not null as expected.");
    }

    @Test
    public void testRegisterPayment() {
        Amount payment = new Amount(10);
        Amount change = currentSale.registerPayment(payment); 
        saleDTO = currentSale.endSale();

        boolean expResult = true;
        boolean result = 10 == saleDTO.getAmountPaid().getAmount();

        assertEquals(expResult, result,
            "The amount specified in registerpayment does not correctly register.");
    }
}
