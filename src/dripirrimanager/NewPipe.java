/*
 * License
 * This software is distributed under the license  * 
 * Open to modification and redistribution * 
 */
package dripirrimanager;

/**
 *
 * @author rober
 */
public class NewPipe {
    
    //data of the pipe
    private String pipeModel;
    private String pipeColor;
    private String pipeCategory;
    private String pipeMaterial;
    private float pipeFlowRate;
    private float pipeCost;
    private float pipeInternalDiameter;
    private float pipeExternalDiameter;
    private float pipeCoilLength;
    
    /**
     * The SETTER Methods
     * 
     */
    
    // set the pipe model name
    public void setPipeModelName(String pipeModel) {
        this.pipeModel = pipeModel;
    }
    
    // set the pipe color
    public void setPipeColor(String pipeColor) {
        this.pipeColor = pipeColor;
    }
    
    // set the pipe category
    public void setPipeCategory(String pipeCategory) {
        this.pipeCategory = pipeCategory;
    }
    
    // set the pipe material
    public void setPipeMaterial(String pipeMaterial) {
        this.pipeMaterial = pipeMaterial;
    }
    
    // set the pipe flow rate
    public void setPipeFlowRate(float pipeFlowRate) {
        this.pipeFlowRate = pipeFlowRate;
    }
    
    // set the pipe cost
    public void setPipeCost(float pipeCost) {
        this.pipeCost = pipeCost;
    }
    
    // set the pipe internal diameter
    public void setPipeInternalDiameter(float pipeInternalDiameter) {
        this.pipeInternalDiameter = pipeInternalDiameter;
    }
    
    //set the pipe External diameter
    public void setPipeExternalDiameter(float pipeExternalDiameter) {
        this.pipeExternalDiameter = pipeExternalDiameter;
    }
    
    //set the pipe coil length
    public void setPipeCoilLength(float pipeCoilLength) {
        this.pipeCoilLength = pipeCoilLength;
    }
    
    /**
     * The GETTER Methods
     * 
     */
    
    // get the pipe model name
    public String getPipeModelName(){
        return pipeModel;
    }
    
    // get the pipe category
    public String getPipeCategory() {
        return pipeCategory;
    }
    
    // get the pipe color
    public String getPipeColor() {
        return pipeColor;
    }
    
    // get the pipe material
    public String getPipeMaterial() {
        return pipeMaterial;
    }
    
    // get the pipe internal Diameter
    public float getPipeInternalDiameter() {
        return pipeInternalDiameter;
    }
    
    // get the pipe external Diameter
    public float getPipeExternalDiameter() {
        return pipeExternalDiameter;
    }
    
    // get the pipe flow rate
    public float getPipeFlowRate() {
        return pipeFlowRate;
    }
    
    // get the pipe coil length
    public float getPipeCoilLength() {
        return pipeCoilLength;
    }
    
    // get the pipe cost
    public float getPipeCost() {
        return pipeCost;
    }
}
