import database.DatabaseConnection;
import windows.calendarWindow.Home;
import windows.loginWindow.Login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            DatabaseConnection.connect();

            new Login();
        } catch (SQLException e) {
            new Home();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(DatabaseConnection.status > 0) DatabaseConnection.closeConnection();
        }
    }
}
