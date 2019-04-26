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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.DatabaseManager;
public class CropCategories {
    
    private String message = "";    //the message to be returned after either saving the category to the db or failure to save it
    private PreparedStatement cropCategoryStatement = null;
    private String categorySql = null;
    
    //the constructor
    public CropCategories() {
        
        categorySql = "INSERT INTO cropcategories(categoryName,avgRootDepth,initialKc,midKc,lateKc,foASoilWater) VALUES(?,?,?,?,?,?)";
        cropCategoryStatement = DatabaseManager.getPreparedStatement(categorySql); //obtain the statement to execute the queries
    }
    
    /** Save the crop category to the database*/
    public String saveCropCategory(String category, float rootDepth, float soilWater, ArrayList<Float> cropCoefficients) {
        
        try {
            //populate the prepared statement
            cropCategoryStatement.setString(1, category);
            cropCategoryStatement.setFloat(2, rootDepth);
            cropCategoryStatement.setFloat(3, cropCoefficients.get(0));
            cropCategoryStatement.setFloat(4, cropCoefficients.get(1));
            cropCategoryStatement.setFloat(5, cropCoefficients.get(2));
            cropCategoryStatement.setFloat(6, soilWater);
            
            //execute the SQL to save to the database
            if(cropCategoryStatement.executeUpdate() > 0){
                message = "Crop category \""+ category + "\" added successfully";
            }
            else {
                message = "Error: Crop category \"" + category + "\" not saved!";
            }
        } catch (SQLException ex) {
            Logger.getLogger(CropCategories.class.getName()).log(Level.SEVERE, null, ex);
            message = "Crop category not saved to database!";
        }
        
        return message;
    }
    
    //get crop category average root depth
    //get crop category inition Kc 
    //get crop category fraction of available soil water
    
}
