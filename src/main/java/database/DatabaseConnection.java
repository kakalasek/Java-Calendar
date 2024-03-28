package database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    private static Connection connection = null;

    public static void connect() throws IOException, SQLException {
        if(connection == null){
            Properties prop = new Properties();

            FileInputStream ip = new FileInputStream("src/main/resources/database/config.properties");

            prop.load(ip);

            connection = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
        }
    }

    public static Connection getConnection() throws NullPointerException{
        if(connection != null) return connection;
        throw new NullPointerException("There is no active connection!");
    }

    public static void closeConnection() throws SQLException, NullPointerException {
        if(connection != null){
            connection.close();
            connection = null;
        }
        throw new NullPointerException("There is no active connection!");
    }
}
