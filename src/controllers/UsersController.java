
package controllers;

/**
 *
 * @author robert
 */

import models.Users;

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
       }
       else {
           System.out.println("Not allowed");
       }
    }
    
}
