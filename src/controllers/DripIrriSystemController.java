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

import java.util.ArrayList;

import dripirrimanager.DripIrriSystem;
import ui.DripWorksheet;
import models.DripIrriXMLConfig;
import models.Crop;
import models.Pipe;
import models.Emitter;

public class DripIrriSystemController {
    
    private DripIrriXMLConfig fieldConfig;
    private DripIrriXMLConfig pipeConfig;
    private Crop crop;
    private Pipe pipe;
    private Emitter emitter;
    
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
        return new Pipe().fetchBlankPipes("pipemain");
    }
    /**
     * get the lateral pipes from the database
     * @return ArrayList having the pipes from the specified table
     */
    public ArrayList<String> getLateralPipes() {
        return new Pipe().fetchBlankPipes("pipelateral");
    }
    /**
     * get the manifold pipes from the database
     */
    public ArrayList<String> getMainifoldPipes() {
        return new Pipe().fetchBlankPipes("pipemanifold");
    }
    /**
     * get the main pipes from the database
     * @return 
     */
    public ArrayList<String> getSubmainPipes() {
        return new Pipe().fetchBlankPipes("pipesubmain");
    }
    
    /**
     * get the emitters pipes from the database
     */
    public ArrayList<String> getEmitters() {
        return new Emitter().fetchEmitters();
    }
    
    /**
     * get the dripline pipes from the database
     */
    public ArrayList<String> getDriplinePipes() {
        return new Pipe().fetchDriplinePipes();
    }
    
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
    
    /**
     * ################################## GETTING DATA FROM THE UI #######################################
     */
    // configure the Drip Irrigation system
    public void configureDripIrriSystem(DripIrriSystem dripIrriSystem) {
        
        // begin from here ###############################################%%%%%%%%%%%%%%%
        System.out.println(" $ "+dripIrriSystem.calcNumberOfDriplines());
        
        // print the system data onto the Drip Irrigation System worksheet
        new DripWorksheet(dripIrriSystem).setVisible(true);
        
    }
}
