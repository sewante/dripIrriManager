/*
 * License
 * This software is distributed under the license  * 
 * Open to modification and redistribution * 
 */
package models;

/**
 *
 * @author rober
 */

import java.sql.PreparedStatement;
import dripirrimanager.NewPipe;

public class Pipe {
    
    private PreparedStatement pipeSatatement;
    private String message;
    private String pipeMessage;
    
    /**
     * saves the pipe data into the database for the new pipe
     * @param newPipe
     * @return message string showing failure or success
     */
    public String savePipesData(NewPipe newPipe) {
        
        if(newPipe.getPipeCategory().equals("Lateral pipe")) {
            
        }
        else if(newPipe.getPipeCategory().equals("Manifold pipe")) {
            
        }
        else if(newPipe.getPipeCategory().equals("Main pipe")) {
            
        }
        else if (newPipe.getPipeCategory().equals("Sub-main pipe")) {
            //save 
        }
        else {
            message = "Error: Pipe category not available in system";
        }
        return message;
    }
    
    /**
     * saves the pipe data into the appropriate pipe category table
     * @param pipe
     * @param tableName the name of the table to which to save the data
     * @return String showing failure or success of the operation
     */
    public String savePipe(NewPipe pipe, String tableName) {
        String pipeSql = String.format("INSERT INTO %s(modelName,flowRate,color,interDiameter,exterDiameter,coilLength,material,cost) "
                + "VALUES(?,?,?,?,?,?,?,?)", tableName);
        pipeSatatement = DatabaseManager.getPreparedStatement(pipeSql);
        
        //CONTINUE HERE
        return pipeMessage;
    }
}
