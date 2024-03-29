package windows.calendarWindow.panels.subpanels.parts;

import fileHandler.FileHandler;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;

/**
 * A class which represents the lower part of the day panel
 */
public class LowerPart extends JPanel {

    /* Components and constants used outside the constructor */
    JTextArea notes;
    String[] day;
    String[] monthAndYear;
    String noteFilepath = "src/main/notes/notes";

    public LowerPart(int baseWidth, int baseHeight, String[] day, String[] monthAndYear) throws IOException{
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
            this.add(notes, BorderLayout.CENTER);

            notes.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {

                }

                @Override
                public void focusLost(FocusEvent e) {
                    try {
                        saveNote();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });

    }

    /* Methods */

    /**
     * Saves a note into the notes file. A note is identified by the year, month and day
     * @throws IOException If something goes wrong
     */
    private void saveNote() throws IOException {
        String s = FileHandler.readFile(noteFilepath);  // Reads the contents of the notes file into string s
        JSONObject file;    // Initializes json object

        if(s != null) { // If there already is something in the notes file, it is parsed into json object
            Object o = JSONValue.parse(s);
            file = (JSONObject) o;
        } else {    // If the notes file is empty, empty json object is created
            file = new JSONObject();
        }
        String identifier = monthAndYear[1] + monthAndYear[0] + day[0]; // Creating the identifier for the note. It is a concatenated string from year, month and day respectively

        file.put(identifier, notes.getText());  // Puts the note with its identifier into the file

        FileHandler.writeFile(noteFilepath, file.toJSONString());   // Writes everything back to the notes file
    }

    /**
     * Reads a note from the notes file, which corresponds to this day
     * @return Text of the note. If there is no note for this day yet, return an empty string
     * @throws IOException If something goes wrong
     */
    private String readNote() throws IOException {
        String s = FileHandler.readFile(noteFilepath);  // Reads the contents of the notes file into String s
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
