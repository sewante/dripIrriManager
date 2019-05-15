
package dripirrimanager;

/**
 *
 * @author robert
 */

import models.Crop;
import models.Pipe;
import models.Emitter;

public class DripIrriSystem {

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
    
    
    /**
     * The Setter methods
     */
    // set the crop object
    public void setCrop(String cropName) {
        this.crop = cropModle.fetchCrop(cropName);
    }
    // set the main pipe object
    public void setMainPipe(String mainPipe) {
        
    }
    // set the lateral pipe object
    public void setLateralPipe(String lateralPipe) {
        
    }
    // set the manifold pipe object
    public void setManifoldPipe(String manifoldPipe) {
        
    }
    //set the dripline pipe object
    public void  setDriplinePipe(String dripliePipe) {
        
    }
    // set the emitter object
    public void setEmitter(String emitterName) {
        
    }
    // set the submain pipe object
    public void setSubmainPipe(String submainPipe) {
        
    }
    
    
    /**
     * Other calculations
     */
    
    // calculate system runtime
    // calculate plant water requirement
    // calculate emitter spacing
    // calculate number of emitters
    // calculate wetted area
    // calculate approximate cost
    // calculate main pipe length
    // calculate number of main pipes
    // calculate number of dripline
    // calculate 
    
}
