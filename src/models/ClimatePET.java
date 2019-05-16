/*
 * License
 * This software is distributed under the license  * 
 * Open to modification and redistribution * 
 */
package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dripirrimanager.ErrorLogger;

/**
 *
 * @author robert
 */

public class ClimatePET {
    
    private static float averagePET;
    private  float lowPET;
    private  float highPET;
    private String climate;
    private int applicationEfficiency;
    
    private ErrorLogger logger;
    
    // Constructor
    public ClimatePET(String climatePET) {
        logger = ErrorLogger.getLogger();
        setClimatePET(climatePET); 
    }
    
    // get the average PET
    public  float getAveragePET() {
        averagePET = (lowPET + highPET) / 2;
        return averagePET;
    }
    // get the application efficiency as a decimal point number representation of application efficiency
    public float getApplicationEfficiency() {
        return (float)applicationEfficiency/(float)100;
    }
    // get the climate type of the field
    public String getClimate() {
        return climate;
    }
    // set climate and PET data
    private void setClimatePET(String pet) {
        
        String climateSQL = "SELECT climate,worstPETlow,worstPEThigh,appEfficiency "
                + "FROM pettable WHERE climate='"+pet+"'";
        
        try {
            Statement PETStatement = DatabaseManager.getStatement();
            ResultSet PETResult = PETStatement.executeQuery(climateSQL);
            
            // confirm that the PET and climate were found
            if(PETResult.next()) {
                climate = PETResult.getString("climate");
                lowPET = PETResult.getFloat("worstPETlow");
                highPET = PETResult.getFloat("worstPEThigh");
                applicationEfficiency = PETResult.getInt("appEfficiency");
            }
        }
        catch(SQLException sqle) {
            logger.logError("models.ClimatePET.setClimate "+sqle.getMessage());
        }
        catch(Exception e) {
            logger.logError("models.ClimatePET.setClimate "+e.getMessage());
        }
    }
}
