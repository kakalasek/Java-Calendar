package windows.calendarWindow.panels.subpanels.parts;

import fileHandler.FileHandler;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;

public class LowerPart extends JPanel {

    JTextArea notes;
    String[] day;
    String[] monthAndYear;

    String noteFilepath = "src/main/notes/notes";

    private void saveNote() throws IOException {
        String s = FileHandler.readFile(noteFilepath);
        JSONObject file;

        if(s != null) {
            Object o = JSONValue.parse(s);
            file = (JSONObject) o;
        } else {
            file = new JSONObject();
        }
        String identifier = monthAndYear[1] + monthAndYear[0] + day[0];

        file.put(identifier, notes.getText());

        FileHandler.clearFile(noteFilepath);

        FileHandler.writeFile(noteFilepath, file.toJSONString());
    }

    private String readNote() throws IOException {
        String s = FileHandler.readFile(noteFilepath);
        JSONObject file;

        if(s != null) {
            Object o = JSONValue.parse(s);
            file = (JSONObject) o;
        } else {
            file = new JSONObject();
        }
        String identifier = monthAndYear[1] + monthAndYear[0] + day[0];

        if(file.containsKey(identifier)){
            return (String)file.get(identifier);
        }
        return "";
    }

    public LowerPart(int baseWidth, int baseHeight, String[] day, String[] monthAndYear) {

        try {
            this.day = day;
            this.monthAndYear = monthAndYear;

            /* Base Setup */

            this.setLayout(new BorderLayout());

            this.setMinimumSize(new Dimension(baseWidth, baseHeight));
            this.setPreferredSize(new Dimension(baseWidth, baseHeight));
            this.setMaximumSize(new Dimension(baseWidth, baseHeight));

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

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
