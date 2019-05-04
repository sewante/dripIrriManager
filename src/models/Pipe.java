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

import dripirrimanager.DripLine;
import dripirrimanager.ErrorLogger;
import java.sql.PreparedStatement;
import dripirrimanager.NewPipe;
import java.io.PipedOutputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pipe {
    
    private PreparedStatement pipeStatement;
    private ErrorLogger logger;
    private String message = "";
    private String pipeMessage = "";
    
    public Pipe() {
        logger = ErrorLogger.getLogger();
    }
    
    /**
     * saves the pipe data into the database for the new pipe
     * @param newPipe
     * @return message string showing failure or success
     */
    public String savePipesData(NewPipe newPipe) {
        
        if(newPipe.getPipeCategory().equals("Lateral pipe")) {
            message = saveBlankTubing(newPipe, "pipelateral");
        }
        else if(newPipe.getPipeCategory().equals("Manifold pipe")) {
            message = "Error: Pipe category not available in system";
        }
        else if(newPipe.getPipeCategory().equals("Main pipe")) {
            message = saveBlankTubing(newPipe, "pipemain");
            
        }
        else if (newPipe.getPipeCategory().equals("Sub-main pipe")) {
            //save 
            message = "Error: Pipe category not available in system";
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
    private String saveBlankTubing(NewPipe pipe, String tableName) {
        String pipeSql = String.format("INSERT INTO %s(modelName,flowRate,color,interDiameter,exterDiameter,coilLength,material,cost) "
                + "VALUES(?,?,?,?,?,?,?,?)", tableName);
        pipeStatement = DatabaseManager.getPreparedStatement(pipeSql);
        
        try {
            
            pipeStatement.setString(1, pipe.getPipeModelName());
            pipeStatement.setFloat(2, pipe.getPipeFlowRate());
            pipeStatement.setString(3, pipe.getPipeColor());
            pipeStatement.setFloat(4, pipe.getPipeInternalDiameter());
            pipeStatement.setFloat(5, pipe.getPipeExternalDiameter());
            pipeStatement.setFloat(6, pipe.getPipeCoilLength());
            pipeStatement.setString(7, pipe.getPipeMaterial());
            pipeStatement.setFloat(8, pipe.getPipeCost());
            
            if(pipeStatement.executeUpdate() > 0) {
                pipeMessage = "New pipe \""+ pipe.getPipeModelName().toUpperCase() + "\" saved successfully";
            }
            else {
                pipeMessage = "Failed to save \""+ pipe.getPipeModelName().toUpperCase() + "\" to the system";
            }
        } catch (SQLException ex) {
            
            logger.logError("models.Crop.saveBlankTubing "+ex.getMessage());
            pipeMessage = "Error: Could not add \""+pipe.getPipeModelName()+"\" to the system";
        }
        return pipeMessage;
    }
    
    /**
     * Saves the dripline data into the pipedripline table
     * @param dripLine  the dripline object whose data is to be inserted into the database
     * @param tableName the dripline table
     * @return String showing the failure or the success of the operation
     */
    public String saveDripLine(DripLine dripLine) {
        
        String dripLineSql = String.format("INSERT INTO %s(modelName,flowRate,color,interDiameter,exterDiameter,coilLength,material,cost,comments,emitterSpacing) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?)", "pipedripline");
        pipeStatement = DatabaseManager.getPreparedStatement(dripLineSql);
        
        try {
            
            pipeStatement.setString(1, dripLine.getPipeModelName());
            pipeStatement.setFloat(2, dripLine.getPipeFlowRate());
            pipeStatement.setString(3, dripLine.getPipeColor());
            pipeStatement.setFloat(4, dripLine.getPipeInternalDiameter());
            pipeStatement.setFloat(5, dripLine.getPipeExternalDiameter());
            pipeStatement.setFloat(6, dripLine.getPipeCoilLength());
            pipeStatement.setString(7, dripLine.getPipeMaterial());
            pipeStatement.setFloat(8, dripLine.getPipeCost());
            pipeStatement.setString(9, dripLine.getComments());
            pipeStatement.setFloat(10, dripLine.getEmitterSpacing());
            
            if(pipeStatement.executeUpdate() > 0) {
                message = "New pipe \""+ dripLine.getPipeModelName().toUpperCase() + "\" saved successfully";
            }
            else {
                message = "Failed to save \""+ dripLine.getPipeModelName().toUpperCase() + "\" to the system";
            }
            
        } catch (SQLException ex) {
            
            logger.logError("models.Crop.saveDripLine "+ex.getMessage());
            message = "Error: Could not add \""+dripLine.getPipeModelName()+"\" to the system";
        }
        
        return message;
    }
}
