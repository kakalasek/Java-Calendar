package database.connection;

import exceptionHandler.ExceptionHandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
     * If connection cant be established, is sets a flag in the ExceptionHandler
     * @throws IOException If anything goes wrong with reading the configuration file
     * @throws FileNotFoundException If the configuration file is not found
     */
    public static void connect() throws IOException{
        if(connection == null){
            Properties prop = new Properties();

            try(FileInputStream ip = new FileInputStream(configurationFilePath)) {

                prop.load(ip);

                connection = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));

                status = 1; // Set the status to one to alert the rest of the program, that there is an active connection
            } catch (FileNotFoundException e) { // If the configuration file cant be found
                throw new FileNotFoundException("Configuration file not found!\n" + e.getMessage());
            } catch(IOException e){ // If something else goes wrong with reading the configuration file...
                throw new IOException("Something went wrong while reading the configuration file!", e);
            } catch (SQLException e){ // If the connection cant be established
                ExceptionHandler.displayError("No Database!");
                ExceptionHandler.log("Connection to database could not be established!\n" + e.getMessage() + "\n\n");
            }
        }
    }

    /**
     * Closes the current connection. Needless to say, it must be already established
     * If there is no established connection, this method does nothing at all...
     * @throws SQLException If anything goes wrong with closing the connection
     */
    public static void closeConnection() throws SQLException {
        if(connection != null){ // Check if there is an established connection

            try {
                connection.close();
                connection = null;  // Set connection to null, so a new one could be established
                status = 0; // Set status to 0, so the rest of the program knows, there is no connection anymore

            }catch (SQLException e){
                throw new SQLException("Something went wrong with closing the connection!", e);
            }
        }
    }

    /**
     * Returns a prepared statement
     * @param sql SQL string for the prepared statement
     * @return The prepared statement
     * @throws NullPointerException If there is no established connection
     */
    public static PreparedStatement prepareStatement(String sql) throws NullPointerException, SQLException {
        if(connection != null) {
            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                return ps;
            }catch (SQLException e){
                throw new SQLException("Something went wrong with creating prepared statement!", e);
            }
        } else {
            throw new NullPointerException("There is no established connection!");
        }
    }
}
