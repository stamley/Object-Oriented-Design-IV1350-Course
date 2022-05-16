package se.kth.iv1350.hackers.startup;
import se.kth.iv1350.hackers.controller.Controller;
import se.kth.iv1350.hackers.controller.OperationFailedException;
import se.kth.iv1350.hackers.integration.AccountingSystem;
import se.kth.iv1350.hackers.integration.DBController;
import se.kth.iv1350.hackers.integration.IOController;
import se.kth.iv1350.hackers.view.View;

/**
 * Contains the <code>main</code> method.
 * Performs all startup of the application.
 */

public class Main
{
    /**
    * Starts the application.
    * @param args The application does not take any command line paramteters.
     * @throws OperationFailedException
    */
    public static void main(String[] args) throws OperationFailedException{
        DBController dbHandler = new DBController();
        IOController ioController = new IOController();
        Controller controller = new Controller(ioController, dbHandler);
        View view = new View (controller);
        view.sampleExecution();
    }
}