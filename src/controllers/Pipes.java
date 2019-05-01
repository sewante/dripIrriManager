/*
 * License
 * This software is distributed under the license  * 
 * Open to modification and redistribution * 
 */
package controllers;

import java.util.ArrayList;
import dripirrimanager.NewPipe;
import models.DripIrriXMLConfig;
import models.Pipe;

/**
 *
 * @author robert
 */
public class Pipes {
    
    private Pipe pipe;                      //the pipe model
    private DripIrriXMLConfig pipeConfig;   //the pipe configurations  
    
    /**
     * The Constructor
     */
    public Pipes() {
        
        pipe = new Pipe();          //initialize the pipe model
        pipeConfig = new DripIrriXMLConfig("config\\pipeConfig.xml");
    }
    
    /**
     * ################################## GETTING DATA FROM THE UI #######################################
     */
    
    /**
     * Get the Pipe data from the ui.Dashboard.AddBlankTubing and passes it to the model.Pipe 
     * @param newPipe
     * @return string message showing success or failure
     */
    public String getPipeData(NewPipe newPipe) {
        
        return pipe.savePipesData(newPipe);
    }
    
    /**
     * ################################## GETTING DATA FROM THE MODEL #######################################
     */
    
    /**
     * get the pipe categories from the XML pipeConfig.xml
     */
    public ArrayList<String> getPipeCategories() {
        return pipeConfig.getChildNodes("pipe-categories");
    }
    
    /**
     * get the pipe types from the XML pipeConfig.xml
     */
    public ArrayList<String> getPipeTypes() {
        return pipeConfig.getChildNodes("pipe-types");
    }
    /**
     * get the pipe color from the XML pipeConfig.xml
     */
    public ArrayList<String> getPipeColors() {
        return new DripIrriXMLConfig("config\\pipeConfig.xml").getChildNodes("colors");
    }
    
    /**
     * get the pipe materials from the XML pipeConfig.xml
     */
    public ArrayList<String> getPipeMaterials() {
        return new DripIrriXMLConfig("config\\pipeConfig.xml").getChildNodes("materials");
    }
    /**
     * get the pipe emitter spacings for drip lines from the XML pipeConfig.xml
     */
    public ArrayList<String> getEmitterSpacing() {
        return new DripIrriXMLConfig("config\\pipeConfig.xml").getChildNodes("emitter-spacing");
    }
    
    
    /**
     * ################################## SENDING DATA TO THE MODEL #######################################
     */
    
}
