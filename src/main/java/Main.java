import database.connection.DatabaseConnection;
import windows.calendarWindow.Home;
import windows.loginWindow.Login;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

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
