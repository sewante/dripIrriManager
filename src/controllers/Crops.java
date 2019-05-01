/*
 * License
 * This software is distributed under the license  * 
 * Open to modification and redistribution * 
 */
package controllers;

import java.util.ArrayList;
import models.CropCategories;
import models.Crop;
import models.DripIrriXMLConfig;
import dripirrimanager.NewCrop;

/**
 *
 * @author rober
 */
public class Crops {
    
    private CropCategories cropCategory;        //the crop category
    
    private Crop crop;                      //the crop model
    private DripIrriXMLConfig pipeConfig;   //the pipe Configurations
    private DripIrriXMLConfig cropConfig;   //the crop configuratios
    
    //the constructor
    public Crops() {
        
        cropCategory = new CropCategories();    //initailize the crop category
        crop = new Crop();
        pipeConfig = new DripIrriXMLConfig("config\\pipeConfig.xml");
        cropConfig = new DripIrriXMLConfig(("config\\cropConfig.xml"));
        
    }
    /**
     * ################################## GETTING DATA FROM THE UI #######################################
     */
    
    /**
     * Get the Crop Category data from the ui.AddCropCategory 
     */
    public String getCropCategoryData(String category, float rootDepth, float soilWater, ArrayList<Float> cropCoefficients) {
        
        return cropCategory.saveCropCategory(category, rootDepth, soilWater, cropCoefficients);
    }
    
    /**
     * Get the Crop data from the ui.Dashboard.AddNewCrop and passes it to the model.Crop 
     */
    public String getCropData(NewCrop newCrop) {
        
        return crop.saveCropData(newCrop);
    }
    /**
     * #################################### GETTING DATA FROM THE MODEL ###################################
     */
    /**
     * Get the pipe categories from the XML pipeConfig.xml
     */
    public ArrayList<String> getPipeCategories () {
      
        return pipeConfig.getChildNodes("pipe-categories");
    }
    
    /**
     * Get the plant schemes from the XML cropConfig.xml
     */
    public ArrayList<String> getPlantScheme() {
        
        return cropConfig.getChildNodes("plant-scheme");
    }
    
    /**
     * Get the crop categories from the database
     */
    public ArrayList<String> getCropCategories () {
        
        return crop.fetchCropCategories();
    }
    /**
     * #################################### SENDING DATA TO THE MODEL ###################################
     */
    
}
