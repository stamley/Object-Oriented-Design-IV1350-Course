package se.kth.iv1350.hackers.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.hackers.controller.Controller;
import se.kth.iv1350.hackers.integration.DBController;
import se.kth.iv1350.hackers.integration.IOController;

import static org.junit.jupiter.api.Assertions.*;

public class ViewTest {
    @Test
    public void testSampleExecution() {
        IOController ioController = new IOController();
        DBController dbController = new DBController();
        Controller controller = new Controller(ioController, dbController);

        View view = new View(controller);
        
        view.sampleExecution();
    }
}
