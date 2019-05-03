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
public class DripLine extends NewPipe{
    
    private float emitterSpacing;
    private String comments;
    
   /**
     * The SETTER Methods
     * 
     */
    
    // set the dripline emitter spacing
    public void setEmitterSpacing(float emitterSpacing) {
        this.emitterSpacing = emitterSpacing;
    }
    
    // set the dripline comments
    public void setComments(String comments) {
        this.comments = comments;
    }
    
    /**
     * The GETTER Methods
     * 
     */
    
    // get the dripline emitter spacing
    public float getEmitterSpacing() {
        return emitterSpacing;
    }
    
    // get the dripline comments
    public String getComments() {
        return comments;
    }
}
