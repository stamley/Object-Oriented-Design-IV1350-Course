package se.kth.iv1350.hackers.view;

import javax.management.openmbean.OpenDataException;

import org.junit.jupiter.api.Test;

import se.kth.iv1350.hackers.controller.Controller;
import se.kth.iv1350.hackers.controller.OperationFailedException;
import se.kth.iv1350.hackers.integration.DBController;
import se.kth.iv1350.hackers.integration.IOController;

public class ViewTest {
    @Test
    public void testSampleExecution() throws OperationFailedException{
        IOController ioController = new IOController();
        DBController dbController = new DBController();
        Controller controller = new Controller(ioController, dbController);

        View view = new View(controller);
        
        view.sampleExecution(); 
    }
}
