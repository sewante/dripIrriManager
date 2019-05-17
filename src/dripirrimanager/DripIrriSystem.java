
package dripirrimanager;

/**
 *
 * @author robert
 */

import models.Crop;
import models.Pipe;
import models.Emitter;

public class DripIrriSystem {

    /*********************SYSTEM CONSTANTS*************************************/
    private float sparseDiameter = (float) 6.5;     //in foot, tobe changed
    private final int EDGE_OFFSET = 4;
    private final float WETTED_AREA_CONSTANT = (float)0.7854;
    private final float ERD_CONSTANT = (float)231.0;    // the Emitter Discharge Rate Constant
    /**************************************************************************/
    //pipe data
    private NewPipe mainPipe;
    private NewPipe lateralPipe;
    private NewPipe submain;
    private NewPipe manifold;
    
    //emitter data
    private NewEmitter emitter;
    private DripLine dripline;
    private Emitter emitterModel;
    
    private Pipe pipeModel;
    
    //the crop data
    private NewCrop crop;
    private Crop cropModle;
    
    // the fields object
    private Field field;
    
    private float waterRequirement;
    private String lateralPipeType;
    private float emitterSpacing;
    private int numberOfEmitters;
    private float actualWidth;          // The actual width minus the edge offset
    private float approximateCost = 0;
    private float systemRuntime = 0;  // the system run time per day in hours
    private float flowRate;
    private float numberOfLateralSpaces = 0;
    
    
    /** CONSTRUCTOR
     * constructor for systems with main,submain, lateral(blank tubing) and emitter 
     * @param mainPipe  The main pipe for the system
     * @param submain   The submain pipe for the system
     * @param lateralPipe   The lateral pipe (blank tubing) for the system
     * @param emitter   The emitter to use on the blank tubing
     * @param field     The field (garden) into which the drip irrigation system is to be set
     */
    public DripIrriSystem(NewPipe mainPipe, NewPipe submain, NewPipe lateralPipe, NewEmitter emitter, Field field) {
        this.mainPipe = mainPipe;
        this.lateralPipe = lateralPipe;
        this.emitter = emitter;
        this.submain = submain;
        
        this.field = field;
        cropModle = new Crop();
        pipeModel = new Pipe();
        emitterModel = new Emitter();
    }
    
    /** CONSTRUCTOR
     * constructor for system that require  no emitter (such systems use a dripline) 
     * @param mainPipe  The main pipe for the system
     * @param submain   The submain pipe for the system 
     * @param manifold  The manifold pipe for the system
     * @param dripline  The dripline pipe for the system
     * @param field     The field (garden) into which the drip irrigation system is to be set
     */
    public DripIrriSystem(NewPipe mainPipe, NewPipe submain,NewPipe manifold, DripLine dripline, Field field) {
        this.mainPipe = mainPipe;
        this.submain = submain;
        this.manifold = manifold;
        this.dripline = dripline;
        this.field = field;
        cropModle = new Crop();
        pipeModel = new Pipe();
    }
    /** CONSTRUCTOR
     * constructor for system that require  a lateral blank tubing and emitters
     * @param mainPipe  The main pipe for the system
     * @param submain   The submain pipe for the system 
     * @param manifold  The manifold pipe for the system
     * @param lateral   The lateral pipe for the system
     * @param emitter   The emitter for the system
     * @param field     The field (garden) into which the drip irrigation system is to be set
     */
    public DripIrriSystem(NewPipe mainPipe, NewPipe submain, NewPipe manifold, NewPipe lateral, NewEmitter emitter, Field field) {
        this.mainPipe = mainPipe;
        this.submain = submain;
        this.manifold = manifold;
        this.lateralPipe = lateral;
        this.emitter = emitter;
        this.field = field;
        cropModle = new Crop(); 
        pipeModel = new Pipe();
        emitterModel = new Emitter();
    }
    /** CONSTRUCTOR
     * Constructor for systems that require only a dripline (This is suitable for small gardens
     * @param dripline  The dripline tubing to be used in the system
     * @param field     The filed/garden into which the drip irrigation system is to be set
     */
    public DripIrriSystem(DripLine dripline, Field field) {
        this.dripline = dripline;
        this.field = field;
        cropModle = new Crop();
        pipeModel = new Pipe();
    }
    /** CONSTRUCTOR
     * Constructor for systems whose pipe data is not specified but the field already set up
     * @param field The field/garden in which the drip irrigation system is to be configured
     */
    public DripIrriSystem(Field field) {
        this.field = field;
        cropModle = new Crop();
        pipeModel = new Pipe();
        emitterModel = new Emitter();
        
        crop = new NewCrop();
    }
    
    /**
     * The Getter methods
     */
    
    // get the Filed object
    public Field getField() {
        return field;
    }
    // get the NewCrop object
    public NewCrop getCrop() {
        return crop;
    }
    // get the main pipe object
    public NewPipe getMainPipe() {
        return mainPipe;
    }
    // get the manifold pipe object
    public NewPipe getManifold() {
        return manifold;
    }
    // get the lateral pipe object
    public NewPipe getLateralPipe() {
        return lateralPipe;
    }
    // get the submain pipe object 
    public NewPipe getSubmain() {
        return submain;
    }
    // get the dripline pipe object
    public DripLine getDripline() {
        return dripline;
    }
    // get the Emitter object
    public NewEmitter getEmitter() {
        return emitter;
    }
    // get the lateral pipe type
    public String getLateralPipeType() {
        return lateralPipeType;
    }
    
    
    /**
     * The Setter methods
     */
    // set the crop object
    public void setCrop(String cropName) {
        this.crop = cropModle.fetchCrop(cropName);
    }
    // set the main pipe object
    public void setMainPipe(String mainPipe) {
        this.mainPipe = pipeModel.fetchPipe(mainPipe, "pipemain");
    }
    // set the lateral pipe object
    public void setLateralPipe(String lateralPipe) {
        this.lateralPipe = pipeModel.fetchPipe(lateralPipe, "pipelateral");
    }
    // set the manifold pipe object
    public void setManifoldPipe(String manifoldPipe) {
        this.manifold = pipeModel.fetchPipe(manifoldPipe, "pipemanifold");
    }
    //set the dripline pipe object
    public void  setDriplinePipe(String dripliePipe) {
       this.dripline = pipeModel.fetchDripline(dripliePipe);
    }
    // set the emitter object
    public void setEmitter(String emitterName) {
        this.emitter = emitterModel.fetchEmitter(emitterName);
    }
    // set the submain pipe object
    public void setSubmainPipe(String submainPipe) {
        this.submain = pipeModel.fetchPipe(submainPipe, "pipesubmain");
    }
    // set the lateral pipe type (is it blank tubing or dripline)
    public void setLateralPipeType(String lateralType) {
        this.lateralPipeType = lateralType;
    }
    
    
    /**
     * Other calculations
     */
    
    // calculate the irrigation interval
    
    // calculate system runtime (number of hours the system should be set to run per day)
    public float calcBlankTubingSystemRuntime() {
        
        float ERD;
        float temp1 = 0,temp2 = 0;
        float latSpecing = 0;   // unused (its just to set the lateral spacing)
        if(crop.getPlantScheme().equals("dense")) {
            temp1 =  ERD_CONSTANT * LphToGph(emitter.getEmitterFlowRate());
            latSpecing = calcActualLateralSpacing();    // this sets the lateral spacing
            temp2 = calcEmitterSpacing() * calcActualLateralSpacing();
            ERD = temp1 / temp2;
            systemRuntime = calcWaterRequirement() / calcAdjustedERD(ERD);  // hours
        }
        else if(crop.getPlantScheme().equals("sparse")) {
            systemRuntime = calcWaterRequirement() / LphToGph(calcFlowRate());
        }
        return systemRuntime;
    }
    // calculate the System run time for dripline
    public float calcDriplineSystemRuntime() {
        
        float ERD = 0;
        float temp1 = 0,temp2 = 0;
        float latSpecing = 0;   // unused (its just to set the lateral spacing)
        
        if(crop.getPlantScheme().equals("dense")) {
            temp1 = ERD_CONSTANT * LphToGph(dripline.getPipeFlowRate());
            
            latSpecing = calcActualLateralSpacing();    // this sets the lateral spacing
            
            temp2 = calcActualLateralSpacing()*calcEmitterSpacing();
            
            ERD = temp1 / temp2;
            systemRuntime = calcWaterRequirement() / calcAdjustedERD(ERD);  // hours
        }
        else if(crop.getPlantScheme().equals("sparse")) {
            systemRuntime = calcWaterRequirement() / LphToGph(calcFlowRate());
        }
        return systemRuntime;
    }
    // calculate Adjusted ERD 
    private float calcAdjustedERD(float originalERD) {
        return originalERD * field.getFieldClimatePET().getApplicationEfficiency();
    }
    // calculate plant water requirement
    public float calcWaterRequirement() {
        
        if(crop.getPlantScheme().equals("dense")) {
            waterRequirement = field.getFieldClimatePET().getAveragePET() * crop.getLateKc(); // inches per day
        }
        else if(crop.getPlantScheme().equals("sparse")) {
            waterRequirement = (NewCrop.SPARSECROPCONSTANT * crop.getCanopyArea(sparseDiameter) *
                    crop.getLateKc() * field.getFieldClimatePET().getAveragePET()) / field.getFieldClimatePET().getApplicationEfficiency(); //gallons per day
        }
        return waterRequirement;
    }
    // calculate emitter spacing in square inch
    public synchronized  float calcEmitterSpacing() {
        
        if(lateralPipeType.equals("Dripline")) {
            emitterSpacing = dripline.getEmitterSpacing();
        }
        else if(lateralPipeType.equals("Blank Tubing")) {
            emitterSpacing = field.getEmitterSpacingForSoil(field.getFieldSoilType());
        }
        return emitterSpacing;
    }
    // calculate wetted area square inch
    public float calcWettedArea() {
        float emitterSpacing = calcEmitterSpacing();
        return emitterSpacing * emitterSpacing * WETTED_AREA_CONSTANT;
    }
    // calculate minimum number of emitters
    public int calcNumberOfEmitters() {
        float emittersPerLateral = calcLengthOfLateral() / calcEmitterSpacing();
        return Math.round(emittersPerLateral * calcNumberOfLaterals());
    }
    // calculate lateral line spaces. These are the number of spaces we expect for laterals eg 5 spaces means we have 5 + 6 rows of plants
    public int calcLateralLineSpaces() {
      
       actualWidth = meterToInch(field.getFieldWidth()) - (float)EDGE_OFFSET;
       
       numberOfLateralSpaces = actualWidth / calcEmitterSpacing();
       
       return Math.round(numberOfLateralSpaces);
    }
    // calculate number of laterals
    public int calcNumberOfLaterals() {
      
        return calcLateralLineSpaces() + 1;
    }
    // calculate the actual spacing between laterals in inch
    public synchronized float calcActualLateralSpacing() {
        return actualWidth / (float)calcLateralLineSpaces();
    }
    // calculate number of crop rows for systems with blank tubing
    public int calcNumberOfRows() {
        return Math.round(actualWidth / crop.getRowSpacing()) + 1;
    }
    // calculate approximate cost
    public float calcApproximateCost() {
       
        if(lateralPipeType.equals("Dripline")) {
            
        }
        else if(lateralPipeType.equals("Blank Tubing")) {
            
        }
        
        return approximateCost;
    }
    // calculate the lateral pipe length
    public float calcLengthOfLateral() {
        return field.getFieldLength();
    }
    // calculate flow rate ot the lateral pipe
    public float calcFlowRate() {
        flowRate = 0;
        if(lateralPipeType.equals("Dripline")) {
            flowRate = dripline.getPipeFlowRate();
        }
        else if(lateralPipeType.equals("Blank Tubing")) {
            flowRate = emitter.getEmitterFlowRate();
        }
        return flowRate;
    }
    // calculate main pipe length
    public float calcLengthOfMainPipe() {
        return field.getFieldWidth();
    }
    // calculate number of main pipes
    // calculate number of dripline
    public int calcNumberOfDriplines() {
              
       actualWidth = meterToInch(field.getFieldWidth()) - EDGE_OFFSET;
       
       float numberOfDriplineSpaces = actualWidth / calcEmitterSpacing();
       
       return Math.round(numberOfDriplineSpaces) + 1;
    }
    
    /**
     * Conversion calculations
    */
    // inch to cm
    // cm to m
    // gallons to liters
    // liters to cubic meters
    
    // m to inch
    private float meterToInch(float meter) {
        return (float) 39.37 * meter;
    }
    // feet to meter
    private float footToMeter(float foot) {
        return foot * (float) 0.3048;
    }
    // liters per hour to gallons per hour
    public float LphToGph(float lph) {
        return (float) 0.264172 * lph;
    }
            
    
}
