/*
 * License
 * This software is distributed under the license  * 
 * Open to modification and redistribution * 
 */
package controllers;

/**
 *
 * @author rober
 */

import dripirrimanager.NewEmitter;
import java.util.ArrayList;
import models.Emitter;
import models.DripIrriXMLConfig;
public class Emitters {
    
    private Emitter emitter;        // the Emitter model
    
    /**
     * The constructor
     */
    public Emitters() {
        emitter = new Emitter();    //initialize the emitter model
    }
    
    
    /**
     * #################################### GETTING DATA FROM THE MODEL ###################################
    */
    /**
     * Get the emitter categories from the XML emitterConfig.xml
    */
    public ArrayList<String> getEmitterCategories() {
      
        return new DripIrriXMLConfig("config\\emitterConfig.xml").getChildNodes("categories");
    }
    /**
     * Get the emitter colors from the XML emitterConfig.xml
    */
    public ArrayList<String> getEmitterColors() {
      
        return new DripIrriXMLConfig("config\\emitterConfig.xml").getChildNodes("colors");
    }
    /**
     * Get the emitter filtration from the XML emitterConfig.xml
    */
    public ArrayList<String> getEmitterFiltration() {
      
        return new DripIrriXMLConfig("config\\emitterConfig.xml").getChildNodes("filtration");
    }
    /**
     * Get the emitter inlet types from the XML emitterConfig.xml
    */
    public ArrayList<String> getEmitterInletType() {
      
        return new DripIrriXMLConfig("config\\emitterConfig.xml").getChildNodes("inlet-type");
    }
    
    /**
     * #################################### GETTING DATA FROM THE UI ###################################
    */
    
    /**
     * Get the Emitter data from the ui.Dashboard and passes it to the model.Emitter 
     * @param newEmitter
     * @return string message showing success or failure
     */
    public String getEmitterData(NewEmitter newEmitter) {
        
        return emitter.saveEmitterData(newEmitter);
    }
    
}
