/*
 * License
 * This software is distributed under the license  * 
 * Open to modification and redistribution * 
 */
package controllers;

import java.util.ArrayList;
import models.CropCategories;

/**
 *
 * @author rober
 */
public class Crops {
    private CropCategories cropCategory;    //the crop category
    private ArrayList<Float> cropCoefficient;
    
    //the constructor
    public Crops() {
        cropCoefficient = null;
        cropCategory = new CropCategories();    //initailize the crop category
    }
    //add new crops
    /** Get the Crop Category data from the ui.AddCropCategory */
    public String getCropCategoryData(String category, float rootDepth, float soilWater, ArrayList<Float> cropCoefficients) {
        
        return cropCategory.saveCropCategory(category, rootDepth, soilWater, cropCoefficients);
    }
    
    
}
