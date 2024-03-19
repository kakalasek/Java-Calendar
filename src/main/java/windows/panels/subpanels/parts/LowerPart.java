package windows.panels.subpanels.parts;

import fileHandler.FileHandler;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;

public class LowerPart extends JPanel {

    JTextArea notes;
    String[] day;
    String[] monthAndYear;

    private void saveNote() throws IOException {
        JSONObject file = new JSONObject();
        String identifier = monthAndYear[1] + monthAndYear[0] + day[0];

        file.put(identifier, notes.getText());

        FileHandler.writeFile("src/main/notes/logs", file.toJSONString());
    }

    public LowerPart(int baseWidth, int baseHeight, String[] day, String[] monthAndYear){

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
}
