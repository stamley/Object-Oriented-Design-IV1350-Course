package sourcepackage.se.kth.iv1350.hackers.integration;

/**
 * A representation of the class that controls and manages
 * the IO systems.
 */
public class IOController {
    private SaleLog saleLog;
    private Printer printer;
    private CashRegister cashRegister;

    public IOController()
    {
        saleLog = new SaleLog();
        printer = new Printer();
        cashRegister = new CashRegister(0);
    }

    /**
     * Gets the value of saleLog.
     * @return The value of saleLog.
     */
     public SaleLog getSaleLog(){
        return saleLog;
     }

     /**
      * Logs the sale into the sale log
      * @param saleInformation SaleDTO containing information of sale.
      */

     public void logSale(SaleDTO saleInformation){
        saleLog.logSale(saleInformation);
     }

     /**
      * Adds payment to the cash register
      * @param payment amount paid by customer
      */

     public void addPayment(Amount payment){
         cashRegister.addPayment(payment);
     }

     /**
      * Prints the current receipt
      * @param currentReceipt Receipt to be printed.
      */

     public void printReceipt(Receipt currentReceipt){
        printer.printReceipt(currentReceipt);
     }
}
