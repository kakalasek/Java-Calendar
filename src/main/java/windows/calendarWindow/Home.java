package windows.calendarWindow;

import database.connection.DatabaseConnection;
import database.objects.notes.Notes;
import database.objects.user.User;
import exceptionHandler.ExceptionHandler;
import windows.calendarWindow.panels.CalendarPanel;
import windows.calendarWindow.panels.UpperPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

/**
 * A class which represents the home window
 */
public class Home extends JFrame {

    public static User currentUser = null;  // Is here to keep track of the current user

    public static Home homeFrame = null;

    public static Notes notes = null;

    public Home(User currentUser) {
        /* Constants */
        final int BASE_WIDTH = 1500;
        final int UPPER_BASE_HEIGHT = 100;
        final int CALENDAR_BASE_HEIGHT = 800;

        Home.currentUser = currentUser; // Sets the current user
        Home.homeFrame = this;   // Sets the home frame... used to monitor window close events
        if(DatabaseConnection.status > 0){

        }

        /* Start Setup */
        this.setTitle("Kalendář");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent windowEvent) {

            }

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                if (DatabaseConnection.status > 0) {
                    try {
                        DatabaseConnection.closeConnection();    // If there was a database connection, close it
                    } catch (SQLException e) {
                        ExceptionHandler.log(e.getMessage());
                        throw new RuntimeException(e);  // If an error like this happens, the program logs and stops running
                    }
                }
            }

            @Override
            public void windowClosed(WindowEvent windowEvent) {

            }

            @Override
            public void windowIconified(WindowEvent windowEvent) {

            }

            @Override
            public void windowDeiconified(WindowEvent windowEvent) {

            }

            @Override
            public void windowActivated(WindowEvent windowEvent) {

            }

            @Override
            public void windowDeactivated(WindowEvent windowEvent) {

            }
        });

            /* Layout Setup */
            this.getContentPane().setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weightx = 1.0;

        /* Components */

            /* Initialize Panels */
            UpperPanel upperPanel = new UpperPanel(BASE_WIDTH, UPPER_BASE_HEIGHT);
            CalendarPanel calendarPanel = new CalendarPanel(BASE_WIDTH, CALENDAR_BASE_HEIGHT, upperPanel::getCurrentMonthYear);
            upperPanel.setCalendar(calendarPanel);

            ExceptionHandler.initializeErrorPanel(upperPanel);

            /* Position UpperPanel */
            gbc.weighty = 0.0;
            gbc.gridx = 0;
            gbc.gridy = 0;
            this.getContentPane().add(upperPanel, gbc);

            /* Position CalendarPanel */
            gbc.weighty = 1.0;
            gbc.gridx = 0;
            gbc.gridy = 1;
            this.getContentPane().add(calendarPanel, gbc);

        /* End Setup */
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
}
