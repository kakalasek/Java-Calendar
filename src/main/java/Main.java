import database.DatabaseConnection;
import windows.calendarWindow.Home;
import windows.loginWindow.Login;

public class Main {
    public static void main(String[] args) {
        //new Login();
        try{
            DatabaseConnection.connect();

            DatabaseConnection.closeConnection();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
