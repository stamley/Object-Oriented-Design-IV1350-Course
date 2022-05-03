package sourcepackage.se.kth.iv1350.hackers.view;
import sourcepackage.se.kth.iv1350.hackers.controller.Controller;
import sourcepackage.se.kth.iv1350.hackers.util.*;

/**
 * The application does not have an actual view, and this class
 * is a placeholder.
 */

public class View {
    private Controller controller;
    
    /**
     * Creates a new instance of view.
     * 
     * @param controller the class where all calls are being made.
     */
    public View(Controller controller){
        this.controller = controller;
    }
    /**
     * Fake execution from the view.
     * 
     */
    public void sampleExecution(){
        controller.registerPayment(new Amount(200));
    }

   
}