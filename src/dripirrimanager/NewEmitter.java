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
public class NewEmitter {
    
    //data for a new Emitter
    private String modelName;
    private String inletType;
    private String color;
    private String category;
    
    private int filtration;
    private float cost;
    private float flowRate;
    
    
    /**
     * The setter methods
     */
    //set the emitter model name
    public void setEmitterModelName(String model) {
        this.modelName = model;
    }
    //set the emitter category
    public void setEmitterCategory(String category) {
        this.category = category;
    }
    //set the emitter inletType
    public void setEmitterInletType(String inletType) {
        this.inletType = inletType;
    }
    //set the emitter color
    public void setEmitterColor(String color) {
        this.color = color;
    }
    //set the emitter filtration
    public void setEmitterFiltration(int filtration) {
        this.filtration = filtration;
    }
    //set the emitter cost
    public void setEmitterCost(float cost) {
        this.cost = cost;
    }
    //set the emitter flow rate
    public void setEmitterFlowRate(float flowRate) {
        this.flowRate = flowRate;
    }
    
    
    
    /**
     * The getter methods
     */
    //get the emitter model name
    public String getEmitterModelName(){
        return modelName;
    }
    //get the emitter category
    public String getEmitterCategory(){
        return category;
    }
    //get the emitter color
    public String getEmitterColor(){
        return color;
    }
    //get the emitter filtration
    public int getEmitterFiltration(){
        return filtration;
    }
    //get the emitter flow rate
    public float getEmitterFlowRate(){
        return flowRate;
    }
    //get the emitter cost
    public float getEmitterCost(){
        return cost;
    }
    //get the emitter inlet type
    public String getEmitterInletType(){
        return inletType;
    }
    
}
