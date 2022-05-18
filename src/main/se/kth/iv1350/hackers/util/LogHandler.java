package se.kth.iv1350.hackers.util;

import java.time.LocalDateTime;
import java.io.*;
/**
 * Prints log messages to a file. The log file will be in the
 * current directory and will be called log.txt.
*/

public class LogHandler {
    private static final String LOG_FILE_NAME = "dev-errorlog.txt";
    private static final String TOTAL_REVENUE_FILE = "totalRevenue.txt";

    private PrintWriter logFile;
    private PrintWriter totalRevFile;

    /**
     * Creates a new instance and also creates a new log file.
    * 
    */
    public LogHandler(){
        try{
            logFile = new PrintWriter(new FileWriter(LOG_FILE_NAME), true);
            
        } catch(IOException ioexc){
            System.out.println(ioexc);
        } 
        try {
        totalRevFile = new PrintWriter(new FileWriter(TOTAL_REVENUE_FILE), true);
        }
        catch (IOException ioexc){
            System.out.print(ioexc);
        }       
    }

    /**
     * Writes an entry to the log describing the exception thrown.
     * 
     * @param
     */
    public void logException(Exception exc){
        StringBuilder logTextBuilder = new StringBuilder();
        logTextBuilder.append(LocalDateTime.now().toString());
        logTextBuilder.append(", Exception was thrown: ");
        logTextBuilder.append(exc.getMessage());
        logFile.println(logTextBuilder);
        exc.printStackTrace(logFile); 
    }
    public void log (String message){
        totalRevFile.println(message);
        System.out.println();
    }
}
