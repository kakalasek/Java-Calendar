package windows.panels.subpanels.parts;

import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class LowerPart extends JPanel {

    JTextArea notes;
    String[] day;
    String[] monthAndYear;

    private void saveNote(){
        JSONObject file = new JSONObject();
        String identifier = monthAndYear[1] + monthAndYear[0] + day[0];

        file.put(identifier, notes.getText());

        System.out.println(file);
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
                saveNote();
            }
        });
    }
}
