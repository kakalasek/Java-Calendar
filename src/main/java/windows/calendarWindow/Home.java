package windows.calendarWindow;

import database.connection.DatabaseConnection;
import database.objects.notes.Notes;
import database.objects.notes.NotesDaoImpl;
import database.objects.user.User;
import exceptionHandler.ExceptionHandler;
import fileHandler.FileHandler;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import windows.calendarWindow.panels.CalendarPanel;
import windows.calendarWindow.panels.UpperPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * A class which represents the home window
 */
public class Home extends JFrame {

    public static User currentUser = null;  // Is here to keep track of the current user

    public static Home homeFrame = null;

    private Notes notes = fileIntoObject();

    private final String noteFilepath = "src/main/notes/notes";

    public Home(User currentUser) {
        /* Constants */
        final int BASE_WIDTH = 1500;
        final int UPPER_BASE_HEIGHT = 100;
        final int CALENDAR_BASE_HEIGHT = 800;

        Home.currentUser = currentUser; // Sets the current user
        Home.homeFrame = this;   // Sets the home frame... used to monitor window close events
        NotesDaoImpl notesDao = new NotesDaoImpl();


        /* Start Setup */
        this.setTitle("Kalendář");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent windowEvent) {

                notesDao.saveAll(notes);

                try {
                    FileHandler.writeFile(noteFilepath, "", false);
                } catch (IOException e) {
                    ExceptionHandler.log("Could not clear notes!\n" + e.getMessage() + "\n\n");
                    ExceptionHandler.displayError("Write Error!");
                }
                notes = notesDao.getAllByUser(Home.currentUser.getUsername());

                objectIntoFile(notes);
            }

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                if (DatabaseConnection.status > 0) {
                    notes = fileIntoObject();
                    notesDao.saveAll(notes);

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

    private Notes fileIntoObject(){
        Notes output = new Notes();
        String s = "";

        try {
            s = FileHandler.readFile(noteFilepath);  // Reads the contents of the notes file into String s
        }catch (IOException e){
            ExceptionHandler.log("Could not read notes!\n" + e.getMessage() + "\n\n");
            ExceptionHandler.displayError("Read Error!");
        }
        JSONObject file;    // Initializes json object

        if(s != null) { // If there already is something in the notes file, it is parsed into json object
            Object o = JSONValue.parse(s);
            file = (JSONObject) o;
        } else {    // If the notes file is empty, empty json object is created
            file = new JSONObject();
        }

        file.forEach((k, v) -> {
            output.put((String)k,(String)v);
        });

        return output;
    }

    private void objectIntoFile(Notes notes){
        JSONObject file;    // Initializes json object

        file = new JSONObject();

        notes.forEach((k, v) -> {
            file.put(k, v);
        });

        try {
            FileHandler.writeFile(noteFilepath, file.toJSONString(), false);   // Writes everything back to the notes file
        }catch (IOException e){
            ExceptionHandler.log("Could not save note!\n" + e.getMessage() + "\n\n");
            ExceptionHandler.displayError("Write Error!");
        }
    }
}
