import database.connection.DatabaseConnection;
import exceptionHandler.ExceptionHandler;
import windows.loginWindow.Login;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            DatabaseConnection.connect();

            new Login();

            if (DatabaseConnection.status > 0) DatabaseConnection.closeConnection();
        } catch (IOException | SQLException e) {
            ExceptionHandler.log(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}