package windows.panels.subpanels;

import windows.panels.UpperPanel;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class UpperPart extends JPanel {

    public UpperPart(int baseWidth, int baseHeight){

        this.setMinimumSize(new Dimension(baseWidth, baseHeight));
        this.setPreferredSize(new Dimension(baseWidth, baseHeight));
        this.setMaximumSize(new Dimension(baseWidth, baseHeight));

        this.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0,0,2, 0, Color.black), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
    }
}
