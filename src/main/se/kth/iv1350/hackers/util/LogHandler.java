package se.kth.iv1350.hackers.util;

import java.time.LocalDateTime;
import java.io.*;

public class LogHandler {
    private static final String LOG_FILE_NAME = "dev-errorlog.txt";

    private PrintWriter logFile;

    public LogHandler(){
        try{
            logFile = new PrintWriter(new FileWriter(LOG_FILE_NAME), true);
        } catch(IOException ioexc){
            System.out.println(ioexc);
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
}
