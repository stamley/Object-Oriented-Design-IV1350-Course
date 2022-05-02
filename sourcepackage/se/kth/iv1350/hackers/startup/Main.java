package sourcepackage.se.kth.iv1350.hackers.startup;
import sourcepackage.se.kth.iv1350.hackers.integration.DBController;
import sourcepackage.se.kth.iv1350.hackers.integration.IOController;
import sourcepackage.se.kth.iv1350.hackers.controller.Controller;
import sourcepackage.se.kth.iv1350.hackers.view.View;

/**
 * Contains the <code>main</code> method.
 * Performs all startup of the application.
 */

public class Main
{
    /**
    * Starts the application.
    * @param args The application does not take any command line paramteters.
    */
    public static void main(String[] args){
        DBController dbHandler = new DBController();
        IOController ioController = new IOController();
        Controller controller = new Controller(ioController, dbHandler);
        View view = new View (controller);
    }
}