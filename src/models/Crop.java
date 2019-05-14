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
import dripirrimanager.NewCrop;
import dripirrimanager.ErrorLogger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * This file is the model for handling the crop data
 * it fetches the crop data
 * it saves the newly created crop to the system database
 */
public class Crop {
    
    private String cropSql;
    private ArrayList<String> cropCategories;
    private ArrayList<String> crops;
    private Statement categoriesStatement;
    private String message;
    private PreparedStatement cropStatement;
    private ErrorLogger logger;
    /**
     * The constructor
     * it initializes the Database Manager object for connecting to the database
     */
    public Crop() {
        
        logger = ErrorLogger.getLogger();
        categoriesStatement = DatabaseManager.getStatement();
        cropCategories = new ArrayList<String>();
        crops = new ArrayList<>();
    }
    
    /**
     * Gets the Crop categories names from the database and adds them into an arraylist
     * @return  The array list having the crop categories
     */
    public ArrayList<String> fetchCropCategories() {
        
        try {
            String categoriesSQL = "SELECT categoryName FROM cropcategories";
            ResultSet categoriesResult = categoriesStatement.executeQuery(categoriesSQL);
            
            int categoryCounter = 0;
            while(categoriesResult.next()) {
               cropCategories.add(categoryCounter, categoriesResult.getString("categoryName"));
                categoryCounter++;
            }
              
        } catch (SQLException ex) {
            
            logger.logError("models.Crop.fetchCropCategories "+ex.getMessage());
        }
        catch(Exception e){
            System.out.println(" Problem " + e.getMessage());
            ErrorLogger.getLogger().logError("models.Crop.fetchCropCategories "+e.getMessage());
        }
         return cropCategories;
    }
    
    /**
     * Gets the Crops  names from the database and adds them into an arraylist
     * @return  The array list having the names of the crops
     */
    public ArrayList<String> fetchCrops() {
        
        Statement cropStatement = DatabaseManager.getStatement();
        try {
            String cropSQL = "SELECT name FROM crop";
            ResultSet cropResultSet = cropStatement.executeQuery(cropSQL);
            
            int cropCounter = 0;
            while(cropResultSet.next()) {
               crops.add(cropCounter, cropResultSet.getString("name"));
                cropCounter++;
            }
              
        } catch (SQLException ex) {
            
            logger.logError("models.Crop.fetchCrops "+ex.getMessage());
        }
        catch(Exception e){
            System.out.println(" Problem " + e.getMessage());
            ErrorLogger.getLogger().logError("models.Crop.fetchCrops "+e.getMessage());
        }
         return crops;
    }
    /**
     * Saves the crop data into the database for newly added crop
     * @param newCrop   The new crop object to save
     * @return  The message showing the status of the previous execution (success or failure)
     */
    public String saveCropData(NewCrop newCrop){
        int cropCategoryId = 0;
        try {
            
            //fetch the crop the crop category id
            String cropCategoryIdSQL = "SELECT categoryId FROM cropcategories WHERE categoryName='"+newCrop.getCropCategory()+"'";
            Statement cropCategoryStatement = DatabaseManager.getStatement();
            ResultSet categoryResultSet = cropCategoryStatement.executeQuery(cropCategoryIdSQL);
            if(categoryResultSet.next()){
                cropCategoryId = categoryResultSet.getInt("categoryId");
            }
            else {
                //handle the absence later
            }
            
            cropSql = "INSERT INTO crop(cropcategory,name,shallowRootDepth,deepRootDepth,cropspacing,rowspacing,initialKc,midKc,lateKc,plantingScheme)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?)";
            
            
            cropStatement = DatabaseManager.getPreparedStatement(cropSql);
            
            cropStatement.setInt(1, cropCategoryId);
            cropStatement.setString(2,newCrop.getCropName());
            cropStatement.setFloat(3, newCrop.getCropDepths().get(0));
            cropStatement.setFloat(4, newCrop.getCropDepths().get(1));
            cropStatement.setFloat(5, newCrop.getCropSpacing());
            cropStatement.setFloat(6, newCrop.getRowSpacing());
            cropStatement.setFloat(7, newCrop.getCropCoefficients().get(0));    //set the initial season kc
            cropStatement.setFloat(8, newCrop.getCropCoefficients().get(1));    //set the mid season kc
            cropStatement.setFloat(9, newCrop.getCropCoefficients().get(2));    //set the late season kc
            cropStatement.setString(10, newCrop.getPlantScheme());
            
            
            
            
            //save the new crop prepared statement to the database
            if(cropStatement.executeUpdate() > 0) {
                message = "New crop \""+ newCrop.getCropName().toUpperCase() + "\" saved successfully";
            }
            else {
                message = "Failed to save \""+ newCrop.getCropName().toUpperCase() + "\" to the database";
            } 
        } catch (SQLException ex) {
            
            logger.logError("models.Crop.saveCropData "+ex.getMessage());
            message = "Error: Failed to insert the crop \""+newCrop.getCropName() + "\" into the system";
        }     
        
        return message;
    }
}
