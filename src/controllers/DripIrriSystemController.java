/*
 * License
 * This software is distributed under the license  * 
 * Open to modification and redistribution * 
 */
package controllers;

/**
 *
 * @author robert
 */

import dripirrimanager.DripIrriSystem;
import java.util.ArrayList;
import models.DripIrriXMLConfig;
import models.Crop;
import models.Pipe;

public class DripIrriSystemController {
    
    private DripIrriXMLConfig fieldConfig;
    private DripIrriXMLConfig pipeConfig;
    private Crop crop;
    private Pipe pipe;
    
    // the constructor
    public DripIrriSystemController() {
        
        crop = new Crop();              // initialize the crop model
        pipe = new Pipe();              //initialize the pipe model
        fieldConfig = new DripIrriXMLConfig("config\\fieldConfig.xml");  //initialize the fieldConfig
        pipeConfig = new DripIrriXMLConfig("config\\pipeConfig.xml"); //initialize the pipeConfig
    }
    
    
    /**
     * ################################## GETTING DATA FROM THE MODEL #######################################
     */
    /**
     * get the crops from the database
     */
    public ArrayList<String> getCrops() {
        return crop.fetchCrops();
    }
    /**
     * get the main pipes from the database
     */
    public ArrayList<String> getMainPipes() {
        return pipe.fetchPipes("pipemain");
    }
    /**
     * get the lateral pipes from the database
     * @return ArrayList having the pipes from the specified table
     */
    public ArrayList<String> getLateralPipes() {
        return pipe.fetchPipes("pipelateral");
    }
    /**
     * get the manifold pipes from the database
     */
    
    /**
     * get the lateral pipes from the database
     */
    
    /**
     * get the dripline pipes from the database
     */
    
    /**
     * ################################## SENDING DATA TO THE UI #######################################
     */
    /**
     * get the well types from the XML fieldConfig.xml
     * @return an ArrayList having the well types
     */
    public ArrayList<String> getWellTypes() {
        return fieldConfig.getChildNodes("well-type");
    }
    
    /**
     * get the later pipe types from the XML pipeConfig.xml
     * @return an ArrayList having the well types
     */
    public ArrayList<String> getLateralPipeTypes() {
        return pipeConfig.getChildNodes("lateral-type");
    }
    
    
}
