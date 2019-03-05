
package controllers;

/**
 *
 * @author robert
 */

import javax.swing.JOptionPane;
import models.Users;
import ui.Dashboard;
import ui.LoginUi;

public class UsersController {
    
    private Users user;
    
    public UsersController() {
        
        //initialise the Users model
        user = new Users();
    }
    
    //handle the login of the user
    public void login(String userName, String paasword) {
        
       if(user.loginUser(userName, paasword)) {
           System.out.println("Alloweed");
           new Dashboard().setVisible(true);    //load the user dashboard
       }
       else {
           System.out.println("Not allowed");
           JOptionPane.showMessageDialog(null, "Invalid Credentials", "Login Error", JOptionPane.ERROR_MESSAGE);
           new LoginUi().setVisible(true);  //open the login frame for the user to try again
       }
    }
    
}
