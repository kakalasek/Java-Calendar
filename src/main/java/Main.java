import database.connection.DatabaseConnection;
import windows.calendarWindow.Home;
import windows.loginWindow.Login;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            DatabaseConnection.connect();   // CODE

            new Login();                    // CODE
        } catch (SQLException e) {
            try {
                new Home();                 // CODE
            }catch (IOException ex){
                ex.printStackTrace();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
            if(DatabaseConnection.status > 0) DatabaseConnection.closeConnection(); // CODE
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

