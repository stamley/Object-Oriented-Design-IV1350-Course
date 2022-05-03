package testpackage.se.kth.iv1350.hackers.model;


import sourcepackage.se.kth.iv1350.hackers.model.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import sourcepackage.se.kth.iv1350.hackers.DTO.*;
import sourcepackage.se.kth.iv1350.hackers.util.Amount;
import org.junit.Test;

public class ReceiptTest{

    @Test
    public void testReceiptToString() {
        TotalPrice totalPrice = new TotalPrice();

        LocalDateTime localDateTime = LocalDateTime.now();


    
    
    }
}

private final TotalPrice totalPrice;
private final LocalDateTime localDateTime;
private HashMap <String, Item> items = new HashMap<String, Item>();
private Amount amountPaid;
private Amount changeAmount;
