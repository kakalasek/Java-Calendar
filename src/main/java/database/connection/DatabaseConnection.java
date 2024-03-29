package database.connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

    private static final String configurationFilePath = "src/main/resources/database/config.properties";    // Path to the configuration file
    /**
     * Establishes a connection. It gets the url, username and password from a configuration file
     * If there already is a connection, this method does nothing
     * @throws IOException if anything goes wrong with reading the configuration file
     */
    public static void connect() throws IOException{
        if(connection == null){
            Properties prop = new Properties();

            try(FileInputStream ip = new FileInputStream(configurationFilePath)) {

                prop.load(ip);

                connection = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));

                status = 1; // Set the status to one to alert the rest of the program, that there is an active connection
            } catch (FileNotFoundException e) {
                throw new FileNotFoundException("Configuration file not found!\n" + e.getMessage());
            } catch(IOException e){
                throw new IOException("Something went wrong while reading the configuration file!", e);
            } catch (SQLException e){
                System.out.println("Connection to database could not be established!\n" + e.getMessage());
            }
        }
    }

    /**
     * Returns current connection object
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

            try {
                connection.close();
                connection = null;  // Set connection to null, so a new one could be established
                status = 0; // Set status to 0, so the rest of the program knows, there is no connection anymore
                return;

            }catch (SQLException e){
                throw new SQLException("Something went wrong with closing the connection!", e);
            }
        }
        throw new NullPointerException("There is no active connection!");
    }
}
