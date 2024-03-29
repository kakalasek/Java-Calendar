import database.connection.DatabaseConnection;
import windows.calendarWindow.Home;
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
            throw new RuntimeException(e);
        }
    }
}

