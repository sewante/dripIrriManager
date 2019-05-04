/*
 * License
 * This software is distributed under the license  * 
 * Open to modification and redistribution * 
 */
package models;

import dripirrimanager.NewEmitter;
import dripirrimanager.ErrorLogger;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author rober
 */
public class Emitter {
    
    private String message = "";
    private ErrorLogger logger = ErrorLogger.getLogger();
    PreparedStatement emitterStatement;
    
     /**
     * saves the emitter data into the database for the new emitter
     * @param newEmitter
     * @return message string showing failure or success
     */
    public String saveEmitterData(NewEmitter emitter) {
        
        String emitterSql = "INSERT INTO emitter(category,modelName,inletType,color,filtration,flowrate,cost)"
                + "VALUES(?,?,?,?,?,?,?)";
        
        emitterStatement = DatabaseManager.getPreparedStatement(emitterSql);
        
        try {
            
            emitterStatement.setString(1, emitter.getEmitterCategory());
            emitterStatement.setString(2, emitter.getEmitterModelName());
            emitterStatement.setString(3, emitter.getEmitterInletType());
            emitterStatement.setString(4, emitter.getEmitterColor());
            emitterStatement.setInt(5, emitter.getEmitterFiltration());
            emitterStatement.setFloat(6, emitter.getEmitterFlowRate());
            emitterStatement.setFloat(7, emitter.getEmitterCost());
            
            if(emitterStatement.executeUpdate() > 0) {
                message = "New emitter \""+ emitter.getEmitterModelName().toUpperCase() + "\" saved successfully";
            }
            else {
                message = "Failed to save \""+ emitter.getEmitterModelName().toUpperCase() + "\" to the system";
            }
        }
        catch(Exception e) {
            logger.logError("models.Emitter.saveEmitterData "+e.getMessage());
            message = "Error: Could not add \""+emitter.getEmitterModelName()+"\" to the system";
        }
        return message;
    }
}
