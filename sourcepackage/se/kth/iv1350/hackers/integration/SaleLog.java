package sourcepackage.se.kth.iv1350.hackers.integration;
import sourcepackage.se.kth.iv1350.hackers.DTO.SaleDTO;
import java.util.ArrayList;

public class SaleLog {
    private ArrayList<SaleDTO> saleLog = new ArrayList<SaleDTO>();
   

    /**
     * Logs the current sale in the sale log
     * @param saleInformation Containing information of sale in a SaleDTO
     */
    public void logSale(SaleDTO saleInformation){
        saleLog.add(saleInformation);
    }
}
