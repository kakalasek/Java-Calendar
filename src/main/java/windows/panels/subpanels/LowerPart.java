package windows.panels.subpanels;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class LowerPart extends JPanel {

    public LowerPart(int baseWidth, int baseHeight){

        /* Base Setup */

        this.setLayout(new BorderLayout());

        this.setMinimumSize(new Dimension(baseWidth, baseHeight));
        this.setPreferredSize(new Dimension(baseWidth, baseHeight));
        this.setMaximumSize(new Dimension(baseWidth, baseHeight));

        /* Components */

        JTextArea notes = new JTextArea();
        notes.setLineWrap(true);
        notes.setWrapStyleWord(true);
        this.add(notes, BorderLayout.CENTER);
    }
}
