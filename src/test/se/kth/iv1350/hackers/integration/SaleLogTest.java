package se.kth.iv1350.hackers.integration;

import se.kth.iv1350.hackers.DTO.SaleDTO;
import se.kth.iv1350.hackers.model.TotalPrice;
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
        saleDTO = new SaleDTO(new TotalPrice(100,130,0), new LocalDateTime(),);
    }
}
