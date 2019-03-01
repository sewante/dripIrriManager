
package models;

/**
 *
 * @author robert
 */

import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import models.DatabaseManager;

public class Users {
    
    private Statement userStatement;
    private boolean userPresent = false;
    public Users() {
        
        userStatement = DatabaseManager.getStatement();
    }
    
    /**
     * Register a new user
    */
    public void registerUser() {
        
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
            DatabaseManager.reportError(sqle.getMessage());
        }
        
        return userPresent;
    }
}
