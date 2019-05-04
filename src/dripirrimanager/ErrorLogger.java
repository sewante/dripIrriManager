/*
 * License
 * This software is distributed under the license  * 
 * Open to modification and redistribution * 
 */

/**
 * PURPOSE:
 *  Log the errors that occur to help debug the application
 */
package dripirrimanager;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

/**
 *
 * @author robert
 */


public class ErrorLogger {
    
    private static ErrorLogger myloger = null;
    private FileWriter fileWriter;
    private PrintWriter writer;
    
    // private constructor to have controlled access to the logger object
    public ErrorLogger(){
        try {
            //initialize the file

            fileWriter = new FileWriter("logs\\log.log", true); //set true for append mode
            writer = new PrintWriter(fileWriter);
            
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(ErrorLogger.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: "+ ex.getMessage());
        }
        
    }
    
    // static mehod to creat the single instance of the ErrorLogger
    public static ErrorLogger getLogger() {
        
        if(myloger == null) {
            myloger = new ErrorLogger();
        }
        return myloger;
    }
    
    // method to create the logs
    public  void logError(String error) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        
        try{
            writer.println(dateFormat.format(date)+" Error :"+error);
        }
        catch(Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
        finally {
            writer.close();
        }
    }
}
