/*
 * License
 * This software is distributed under the license  * 
 * Open to modification and redistribution * 
 */
package models;

/**
 *
 * @author robert
 */

import dripirrimanager.DripLine;
import dripirrimanager.ErrorLogger;
import dripirrimanager.NewPipe;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Pipe {
    
    private ArrayList<String> pipes;
    private PreparedStatement pipeStatement;
    private NewPipe pipe;
    private DripLine dripline;
    private ErrorLogger logger;
    private String message = "";
    private String pipeMessage = "";
    
    public Pipe() {
        logger = ErrorLogger.getLogger();
        pipes = new ArrayList<>();
        
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
            message = saveBlankTubing(newPipe,"pipemanifold");
        }
        else if(newPipe.getPipeCategory().equals("Main pipe")) {
            message = saveBlankTubing(newPipe, "pipemain");
            
        }
        else if (newPipe.getPipeCategory().equals("Sub-main pipe")) {
            //save 
            message = saveBlankTubing(newPipe, "pipesubmain");
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
    
     /**
     * Gets the pipe  names from the database and adds them into an arraylist
     * @param category  The category / type of the pipe to be fetched (either main, submain, manifold or lateral)
     * @return  The array list having the pipe names for the specified category
     */
    public ArrayList<String> fetchBlankPipes(String category) {
        String pipeSQL = String.format("SELECT modelName FROM %s", category);
        
        Statement pipeStatement = DatabaseManager.getStatement();
        try {
            ResultSet pipeResult = pipeStatement.executeQuery(pipeSQL);
            
            int pipeCounter = 0;
            while(pipeResult.next()) {
                pipes.add(pipeCounter, pipeResult.getString("modelName"));
                pipeCounter++;
            }
        } catch (SQLException ex) {
            logger.logError("models.Pipe.fetchBlankPipes "+ex.getMessage());
        }
        catch(Exception e){
            System.out.println(" Problem " + e.getMessage());
            logger.logError("models.Pipe.fetchBlankPipes "+e.getMessage());
        }
        return pipes;
    }
    
    /**
     * Gets the dripline names from the database and add them into an arraylist
     * @return  The array list having the names of the driplines
     */
    public ArrayList<String> fetchDriplinePipes() {
        String driplineSQL = "SELECT modelName FROM pipedripline";
        
        Statement driplineStatement = DatabaseManager.getStatement();
        try {
            ResultSet driplineResult = driplineStatement.executeQuery(driplineSQL);
            
            int driplineCounter = 0;
            while(driplineResult.next()) {
                pipes.add(driplineCounter, driplineResult.getString("modelName"));
                driplineCounter++;
            }
        } catch (SQLException ex) {
            logger.logError("models.Pipe.fetchDriplinePipes "+ex.getMessage());
        }
        catch(Exception e){
            System.out.println(" Problem " + e.getMessage());
            logger.logError("models.Pipe.fetchDriplinePipes "+e.getMessage());
        }
        return pipes;
    }
    
    /**
     * Gets the Pipe whose pipe category has been specified
     * @param model The model name of the pipe
     * @param type  The type of the pipe (lateral,main,submain,manifold)
     * @return      The pipe object with its data
     */
    public NewPipe fetchPipe(String model, String type) {
       
        pipe = new NewPipe();
        
        String pipeSQL = String.format("SELECT modelName,flowRate,interDiameter,exterDiameter,coilLength,material,cost "
                + "FROM %s WHERE modelName='%s'", type, model);
        
        try {
            Statement pipeStatement = DatabaseManager.getStatement();
            ResultSet pipeResult = pipeStatement.executeQuery(pipeSQL);
            
            // confirm that the pipe was found and set the pipe object up
            if(pipeResult.next()) {
                
                pipe.setPipeModelName(pipeResult.getString("modelName"));
                pipe.setPipeFlowRate(pipeResult.getFloat("flowRate"));
                pipe.setPipeInternalDiameter(pipeResult.getFloat("interDiameter"));
                pipe.setPipeExternalDiameter(pipeResult.getFloat("exterDiameter"));
                pipe.setPipeCoilLength(pipeResult.getFloat("coilLength"));
                pipe.setPipeMaterial(pipeResult.getString("material"));
                pipe.setPipeCost(pipeResult.getFloat("cost"));
            }
            else {
                return null;
            }
        }
        catch(SQLException sqle){
            logger.logError("models.Pipe.fetchPipe "+sqle.getMessage());
        }
        return pipe;
    }
    /**
     * Gets the dripline object whose model name is specified
     * @param model     The model name of the dripline whose data is required
     * @return  THe dripline object
     */
    public DripLine fetchDripline(String model) {
        dripline = new DripLine();
        
        String driplineSQL = String.format("SELECT modelName,flowRate,interDiameter,exterDiameter,coilLength,material,cost,emitterSpacing "
                + "FROM pipedripline WHERE modelName='%s'", model);
        
        try {
            Statement driplineStatement = DatabaseManager.getStatement();
            ResultSet driplineResult = driplineStatement.executeQuery(driplineSQL);
            
            // confirm that the pipe was found and set the pipe object up
            if(driplineResult.next()) {
                
                dripline.setPipeModelName(driplineResult.getString("modelName"));
                dripline.setPipeFlowRate(driplineResult.getFloat("flowRate"));
                dripline.setPipeInternalDiameter(driplineResult.getFloat("interDiameter"));
                dripline.setPipeExternalDiameter(driplineResult.getFloat("exterDiameter"));
                dripline.setPipeCoilLength(driplineResult.getFloat("coilLength"));
                dripline.setPipeMaterial(driplineResult.getString("material"));
                dripline.setPipeCost(driplineResult.getFloat("cost"));
                dripline.setEmitterSpacing(driplineResult.getFloat("emitterSpacing"));
            }
            else {
                return null;
            }
        }
        catch(SQLException sqle){
            logger.logError("models.Pipe.fetchDripline "+sqle.getMessage());
        }
        
        return dripline;
    }
}
