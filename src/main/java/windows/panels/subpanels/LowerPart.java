package windows.panels.subpanels;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class LowerPart extends JPanel {

    public LowerPart(int baseWidth, int baseHeight){

        this.setMinimumSize(new Dimension(baseWidth, baseHeight));
        this.setPreferredSize(new Dimension(baseWidth, baseHeight));
        this.setMaximumSize(new Dimension(baseWidth, baseHeight));

    }
}
