import database.connection.DatabaseConnection;
import exceptionHandler.ExceptionHandler;
import windows.loginWindow.Login;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            ExceptionHandler.clearLogs();   // Clears logs

            DatabaseConnection.connect();   // Tries to establish a database connection

            new Login();    // Creates the login windows

            if (DatabaseConnection.status > 0) DatabaseConnection.closeConnection();    // If there was a database connection, close it
        } catch (IOException | SQLException e) {    // If any of these errors happens, the program will crash
            ExceptionHandler.log(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}