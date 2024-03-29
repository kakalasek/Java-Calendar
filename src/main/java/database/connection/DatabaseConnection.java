package database.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Class for manipulation with database connection. Every method and property here is static, thus only one connection can exist at one time
 * To create a new one, current connection must be closed
 */
public class DatabaseConnection {

    private static Connection connection = null;
    public static int status = 0;   // Tracks if there is an active connection. If not, any changes are saved locally in a file and saved to database later, when it is possible
                                    // 0 -> No active connection    1 -> Active connection

    /**
     * Establishes a connection. It gets the url, username and password from a configuration file
     * If there already is a connection, this method does nothing
     * @throws IOException If anything goes wrong with reading the configuration file
     * @throws SQLException If anything goes wrong with connection to the database
     */
    public static void connect() throws IOException, SQLException {
        if(connection == null){
            Properties prop = new Properties();

            FileInputStream ip = new FileInputStream("src/main/resources/database/config.properties");

            prop.load(ip);

            connection = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));

            status = 1; // Set the status to one to alert the rest of the program, that there is an active connection
        }
    }

    /**
     * Return current connection object
     * @return The connection object. It must exist
     * @throws NullPointerException If no connection was established
     */
    public static Connection getConnection() throws NullPointerException{
        if(connection != null) return connection;   // Check if there is an established connection
        throw new NullPointerException("There is no active connection!");
    }

    /**
     * Closes the current connection. Needless to say, it must be already established
     * @throws SQLException If anything goes wrong with closing the connection
     * @throws NullPointerException If there is no established connection
     */
    public static void closeConnection() throws SQLException, NullPointerException {
        if(connection != null){ // Check if there is an established connection
            connection.close();
            connection = null;  // Set connection to null, so a new one could be established
            status = 0; // Set status to 0, so the rest of the program knows, there is no connection anymore
            return;
        }
        throw new NullPointerException("There is no active connection!");
    }
}
