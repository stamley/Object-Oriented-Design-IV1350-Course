package se.kth.iv1350.hackers.integration;

import se.kth.iv1350.hackers.DTO.SaleDTO;
import se.kth.iv1350.hackers.model.TotalPrice;
import se.kth.iv1350.hackers.util.Amount;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SaleLogTest {
    private SaleLog saleLog;
    private SaleDTO saleDTO;
    
    @Test
    public void testLogSale() {
        saleLog = new SaleLog();
        TotalPrice totalPrice = new TotalPrice(new Amount(100),new Amount(130), new Amount(0));
        LocalDateTime localDateTime = new LocalDateTime();
        saleDTO = new SaleDTO(totalPrice, new LocalDateTime(), new HashMap<String, Item>(), new);
    }
}
