
package models;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import dripirrimanager.ErrorLogger;

/**
 *
 * @author robert
 */
public class DatabaseManager {
    
    private final static  String databaseUser = "root";
    private final static  String userKey = "";
    private static Connection connection;
    private static ErrorLogger logger = ErrorLogger.getLogger();
    
    private static Connection getDatabaseConnection() {
        connection = null;
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/dripirrimanager", databaseUser, userKey);
      
        }
        catch(ClassNotFoundException cnfe) {
            //report error
            logger.logError("models.DripIrriXMLConfig.getDatabaseConnection "+cnfe.getMessage());
            
        }
        catch(SQLException sqle) {
            //report error
            logger.logError("models.DripIrriXMLConfig.getDatabaseConnection "+sqle.getMessage());
        }
        return connection;
    }
    
    /**
     * Create a statement for executing sql querries on the database
     * @param dbConnection
     * @return dbStatement
    */
    public static final Statement getStatement() {
        Statement dbStatement = null;

        try {
            dbStatement = getDatabaseConnection().createStatement();
        }
        catch(SQLException sqle) {
            //report error
            logger.logError("models.DripIrriXMLConfig.getStatement "+sqle.getMessage());
        }

        return dbStatement;
    }
    
    /**
     * Crete a prepared statement for executing sql querries on the database
    */
    public static final PreparedStatement getPreparedStatement(String sql) {
        
        PreparedStatement dbPreparedStatement = null;
        
        try {
            
            dbPreparedStatement = getDatabaseConnection().prepareStatement(sql);
        }
        catch(SQLException sqle) {
            //report error
            logger.logError("models.DripIrriXMLConfig.getPreparedStatement "+sqle.getMessage());
        }
        
        return dbPreparedStatement;
    }
    
    
    /**
     * report error
     * @param error the error message to report
    */
    public static void reportError(Object error) {
        System.out.println("ERROR: " + error.toString());
    }
}
