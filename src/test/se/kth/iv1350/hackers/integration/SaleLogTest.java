package se.kth.iv1350.hackers.integration;

import se.kth.iv1350.hackers.DTO.ItemDTO;
import se.kth.iv1350.hackers.DTO.SaleDTO;
import se.kth.iv1350.hackers.model.Item;
import se.kth.iv1350.hackers.model.Sale;
import se.kth.iv1350.hackers.util.Amount;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SaleLogTest {
    private Sale currentSale;
    private SaleLog saleLog;
    private SaleDTO saleDTO;
    
    @Test
    public void testLogSale() {
        currentSale = new Sale();
        saleLog = new SaleLog();
        saleDTO = new SaleDTO(currentSale);
        String itemName = "Apple";
        Amount costOfItem = new Amount(2);
        Amount VATOfItem = new Amount(20);

        Item itemToAdd = new Item(new ItemDTO(itemName, costOfItem, VATOfItem), "1234",new Amount(2));
        

        saleLog.logSale(saleDTO);
        boolean expResult = true;
        boolean result = saleLog.getArrayList().get(0).equals(saleDTO);

        assertEquals(expResult, result, "Item in list that was added does not equal the same item that was added.");
    }
}
