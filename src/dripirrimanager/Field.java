/*
 * License
 * This software is distributed under the license  * 
 * Open to modification and redistribution * 
 */
package dripirrimanager;

/**
 *
 * @author robert
 */
import models.ClimatePET;

public class Field {
    
    /*****************Filed Data *************************/
    private float length;
    private float width;
    private float soilEmitterSpacing;
    
    private String soilType;
    private String waterSource;
    private String wellType;
    private String waterQuality;
    private ClimatePET climatePET;
    private String cropGrown;
    private String name;
    private String owner;
    private String address;
    private String city;
    private String contact;
        
    //constructor
    
    /**
     * The Setter Methods
     */
    
    // set the contact of the field 
    public void setFieldContatc(String contact) {
        this.contact = contact;
    }
    // set the city in which the filed is located 
    public void setFieldCity(String city) {
        this.city = city;
    }
    // set the filed's address
    public void setFieldAddress(String address) {
        this.address = address;
    }
    // set the owner of the field
    public void setFiledOwner(String owner) {
        this.owner = owner;
    }
    // set the name of the field
    public void setFiledName(String name) {
        this.name = name;
    }
    // set the filed crop grown
    public void setFieldCropGrown(String cropGrown) {
        this.cropGrown = cropGrown;
    }
    
    // set the field water source
    public void setFieldWaterSource(String waterSource) {
        this.waterSource = waterSource;
    }
    // set the well type for those fields that have wells as their water source
    public  void setFieldWellType(String wellType) {
        this.wellType = wellType;
    }
    // set the field water quality
    public void setFieldWaterQuality(String waterQuality) {
        this.waterQuality = waterQuality;
    }
    // set the climate PET
    public void setFieldClimatePET(String climatePET){
        this.climatePET = new ClimatePET(climatePET);
    }
    
    // set the field width
    public void setFieldWidth(float width) {
        this.width = width;
    }
    // set the field legth
    public void setFieldLenght(float length) {
        this.length = length;
    }
    // set the field soil type
    public void setFieldSoilType(String soilType) {
        this.soilType = soilType;
    }
    
    
    /**
     * The Getter Methods
     */
    
    // get the field length
    public float getFieldLength() {
        return length;
    }
    // get the field with 
    public float getFieldWidth() {
        return width;
    }
    // get the field climate PET
    public ClimatePET getFieldClimatePET() {
        return climatePET;
    }
    // get the field soil type
    public String getFieldSoilType() {
        return soilType;
    }
    // get the field water quality
    public String getFieldWaterQuality() {
        return waterQuality;
    }
    // get the filed water source
    public String getFieldWaterSource() {
        return waterSource;
    }
    // get the well type for those fields whos water source is a well
    public String getFieldWellType() {
        return wellType;
    }
    // get the crop grown in the field
    public String getFieldCropGrown() {
        return cropGrown;
    }
    // get the owner of the field
    public String getFieldOwner() {
        return owner;
    }
    // get the name of the field 
    public String getFieldName() {
        return name;
    }
    // get the filed's city
    public String getFieldCity() {
        return city;
    }
    // get the field's address 
    public String getFieldAddress() {
        return address;
    }
    // get the field's contact
    public String getFieldContact() {
        return contact;
    }
    
    // get the emitter spacing for the soil in inches
    public float getEmitterSpacingForSoil(String soilType) {
        if(soilType.equals("Coarse Soil")) {
            soilEmitterSpacing = (float) 12;
        }
        else if(soilType.equals("Medium Soil")) {
            soilEmitterSpacing = (float) 18;
        }
        else if(soilType.equals("Fine Soil")) {
            soilEmitterSpacing = (float) 24;
        }
        return soilEmitterSpacing;
    }
    
    /**
     * Other calculations on the field
     */
    //calculate the field area
    public float calculateFieldArea() {
        return length * width;
    }
}
