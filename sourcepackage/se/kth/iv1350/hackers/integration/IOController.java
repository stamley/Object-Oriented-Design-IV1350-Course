package sourcepackage.se.kth.iv1350.hackers.integration;

/**
 * A representation of the class that controls and manages
 * the IO systems.
 */
public class IOController {
    private SaleLog saleLog;

    public IOController()
    {
        SaleLog saleLog = new SaleLog();
        Printer printer = new Printer();
        CashRegister cashRegister = new CashRegister(0);
    }

    /**
     * Gets the value of saleLog.
     * @return The value of saleLog.
     */
     public SaleLog getSaleLog(){
         return saleLog;
     }
}
