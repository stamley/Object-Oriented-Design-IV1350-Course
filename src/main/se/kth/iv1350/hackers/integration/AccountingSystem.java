package se.kth.iv1350.hackers.integration;

import java.util.ArrayList;
import se.kth.iv1350.hackers.DTO.SaleDTO;

/**
     * Logs the current sale in the accounting system.
     * 
     * @param saleInformation SaleDTO containing information of sale.
     */
public class AccountingSystem {
  private ArrayList<SaleDTO> accountingSystem = new ArrayList<SaleDTO>();

    /**
     * This is a package private constructor method
     */
    AccountingSystem() {

    }
  
    public void updateAccountingSystem (SaleDTO saleInformation){
        accountingSystem.add(saleInformation);

    }
}
