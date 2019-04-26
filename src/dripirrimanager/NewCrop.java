/*
 * License
 * This software is distributed under the license  * 
 * Open to modification and redistribution * 
 */
package dripirrimanager;

import java.util.ArrayList;

/**
 *
 * @author robert
 */
public class NewCrop {
    
    //data for a crop
    private ArrayList<Float> cropCoefficients;
    private ArrayList<Float> cropDepths;
    private String name;
    private String category;
    private String scheme;
    private float shallowDepth;
    private float deepestDepth;
    private float initialSeasonKc;
    private float midSeasonKc;
    private float lateSeasonKc;
    private float cropSpacing;
    private float rowSpacing;
    
    /**
     * The constructor
     */
    public NewCrop() {
        cropCoefficients = new ArrayList<Float>();
        cropDepths = new ArrayList<Float>();
    }
    /**
     * The setter methods
     */
    //set the crop name
    public void setCropName(String cropName) {
        this.name = cropName;
    }
    //set the crop caegory
    public void setCropCategory(String cropCategory) {
        this.category = cropCategory;
    }
    //set the crop spacing 
    public  void setCropSpacig(float cropSpacing) {
        this.cropSpacing = cropSpacing;
    }
    //the the row spacing
    public void setRowSpacing(float rowSpacing) {
        this.rowSpacing = rowSpacing;
    }
    //set the crop depth
    public void setCropDepth(float low, float high) {
        this.shallowDepth = low;
        this.deepestDepth = high;
        
        cropDepths.add(shallowDepth);
        cropDepths.add(deepestDepth);
    }
    //set the crop coefficients
    public void setCropCoefficients(float initialSeason, float midSeason, float lateSeason){
        this.midSeasonKc = midSeason;
        this.lateSeasonKc = lateSeason;
        this.initialSeasonKc = initialSeason;
        
        cropCoefficients.add(initialSeasonKc);
        cropCoefficients.add(midSeasonKc);
        cropCoefficients.add(lateSeasonKc);
    }
    //set the planting scheme of the crop
    public void setPlantingScheme(String plantScheme) {
        this.scheme = plantScheme;
    }
    
    /**
     * The Getter methods
     */
    
    //get the crop Name
    public String getCropName() {
        return name;
    }
    
    //get the crop category
    public String getCropCategory() {
        return category;
    }
    
    //get the planting scheme 
    public String getPlantScheme() {
        return scheme;
    }
    
    //get the crop coefficients
    public ArrayList<Float> getCropCoefficients() {
        return cropCoefficients;
    }
    
    //get the lowest and highest crop depths
    public ArrayList<Float> getCropDepths() {
        return cropDepths;
    }
    
    //get the crop spacing
    public float getCropSpacing() {
        return cropSpacing;
    }
    
    //get the crop row spacing
    public float getRowSpacing(){
        return rowSpacing;
    }
}
