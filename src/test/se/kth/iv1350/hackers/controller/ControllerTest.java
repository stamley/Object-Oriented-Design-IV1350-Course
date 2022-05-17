package se.kth.iv1350.hackers.controller;

import se.kth.iv1350.hackers.integration.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class ControllerTest{
    private Controller controller;

    @Before
    public void setup()
    {
        controller = new Controller(IOController ioController, DBController dbController);
    }

}
