package windows.calendarWindow.panels.subpanels.parts;

import exceptionHandler.ExceptionHandler;
import fileHandler.FileHandler;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import utils.Utils;
import windows.calendarWindow.Home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

/**
 * A class which represents the lower part of the day panel
 */
public class LowerPart extends JPanel {

    /* Components and constants used outside the constructor */
    private final JTextArea notes;
    private final String[] day;
    private final String[] monthAndYear;
    private final String noteFilepath = "src/main/notes/notes";

    public LowerPart(int baseWidth, int baseHeight, String[] day, String[] monthAndYear){
            /* Constants */
            this.day = day;
            this.monthAndYear = monthAndYear;

            /* Base Setup */
            this.setLayout(new BorderLayout());
            Utils.setupDimensions(this, new Dimension(baseWidth, baseHeight));

            /* Components */
            notes = new JTextArea();
            notes.setLineWrap(true);
            notes.setWrapStyleWord(true);
            notes.setText(readNote());

            notes.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {

                }

                @Override
                public void focusLost(FocusEvent e) {
                    if(!notes.getText().isEmpty()) saveNote();
                }
            });

            this.add(notes, BorderLayout.CENTER);

        Home.homeFrame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                if(!notes.getText().isEmpty()) saveNote();  // If the user closes the window after writing a note, the note gets saved
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    /* Methods */

    /**
     * Saves a note into the notes file. A note is identified by the year, month and day
     */
    private void saveNote(){
        String s = null;
        try {
            s = FileHandler.readFile(noteFilepath);  // Reads the contents of the notes file into string s
        } catch (IOException e){
            ExceptionHandler.log("Could not read note!\n" + e.getMessage() + "\n\n");
            ExceptionHandler.displayError("Read Error!");
        }
        JSONObject file;    // Initializes json object

        if(s != null) { // If there already is something in the notes file, it is parsed into json object
            Object o = JSONValue.parse(s);
            file = (JSONObject) o;
        } else {    // If the notes file is empty, empty json object is created
            file = new JSONObject();
        }
        String identifier = monthAndYear[1] + monthAndYear[0] + day[0]; // Creating the identifier for the note. It is a concatenated string from year, month and day respectively

        file.put(identifier, notes.getText());  // Puts the note with its identifier into the file

        try {
            FileHandler.writeFile(noteFilepath, file.toJSONString(), false);   // Writes everything back to the notes file
        }catch (IOException e){
            ExceptionHandler.log("Could not save note!\n" + e.getMessage() + "\n\n");
            ExceptionHandler.displayError("Write Error!");
        }
    }

    /**
     * Reads a note from the notes file, which corresponds to this day
     * @return Text of the note. If there is no note for this day yet, return an empty string
     */
    private String readNote() {
        String s;

        try {
            s = FileHandler.readFile(noteFilepath);  // Reads the contents of the notes file into String s
        }catch (IOException e){
            ExceptionHandler.log("Could not read note!\n" + e.getMessage() + "\n\n");
            ExceptionHandler.displayError("Read Error!");
            return "";  // If a note cant be read, return an empty string
        }
        JSONObject file;    // Initializes json object

        if(s != null) { // If there already is something in the notes file, it is parsed into json object
            Object o = JSONValue.parse(s);
            file = (JSONObject) o;
        } else {    // If the notes file is empty, empty json object is created
            file = new JSONObject();
        }
        String identifier = monthAndYear[1] + monthAndYear[0] + day[0]; // Creating the identifier for the note. It is a concatenated string from year, month and day respectively

        if(file.containsKey(identifier)){   // If there is a note for this day already, retrieve it and return it
            return (String)file.get(identifier);
        }
        return "";  // If there is no note for this day, return an empty string
    }

}
