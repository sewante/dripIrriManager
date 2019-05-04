
package controllers;

/**
 *
 * @author robert
 */

import javax.swing.JOptionPane;
import models.Users;
import dripirrimanager.ErrorLogger;
import ui.Dashboard;
import ui.LoginUi;

public class UsersController {
    
    private Users user;
    private ErrorLogger logger;
    
    public UsersController() {
        
        //initialise the Users model
        user = new Users();
        logger = ErrorLogger.getLogger();
        
    }
    
    //handle the login of the user
    public void login(String userName, String paasword) {
        
       if(user.loginUser(userName, paasword)) {
           System.out.println("Alloweed");
           new Dashboard().setVisible(true);    //load the user dashboard
       }
       else {
           logger.logError("Invalid Credentials");
           JOptionPane.showMessageDialog(null, "Invalid Credentials", "Login Error", JOptionPane.ERROR_MESSAGE);
           new LoginUi().setVisible(true);  //open the login frame for the user to try again
       }
    }
    
}
