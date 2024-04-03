import database.connection.DatabaseConnection;
import exceptionHandler.ExceptionHandler;
import windows.loginWindow.Login;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            ExceptionHandler.clearLogs();   // Clears logs

            DatabaseConnection.connect();   // Tries to establish a database connection

            new Login();    // Creates the login windows

        } catch (IOException e) {    // If any of these errors happens, the program will crash
            ExceptionHandler.log(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}