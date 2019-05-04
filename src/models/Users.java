
package models;

/**
 *
 * @author robert
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.DatabaseManager;
import dripirrimanager.ErrorLogger;

public class Users {
    
    private ErrorLogger logger;
    private Statement userStatement;
    private boolean userPresent = false;
    public Users() {
        
        logger = ErrorLogger.getLogger();
        userStatement = DatabaseManager.getStatement();
    }
    
    /**
     * Register a new user
    */
    public void registerUser() {
        //to be implemented
    }
    
    /**
     * login a  user
     * @param userName
     * @param password
    */
    public boolean loginUser(String userName, String password) {
        
        String loginSql = String.format("SELECT %s,%s FROM %s", "username", "password", "users");
        
        try {
           
            ResultSet userResult = userStatement.executeQuery(loginSql);
            
            while(userResult.next()) {
                
                if(userResult.getString(1).equals(userName) && userResult.getString(2).equals(password)) {
                    //user exists in database
                    userPresent = true;
                    return userPresent;
                }
                else {
                    userPresent = false;
                }
                
            }
        }
        catch(SQLException sqle) {
            logger.logError("models.User.loginUser "+sqle.getMessage());
        }
        
        return userPresent;
    }
}
