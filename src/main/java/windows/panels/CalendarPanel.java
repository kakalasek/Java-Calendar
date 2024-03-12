package windows.panels;

import windows.panels.subpanels.DayPanel;

import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;

public class CalendarPanel extends JPanel {

    public CalendarPanel(int baseWidth, int baseHeight){
        /* Variables */

        final int DAY_WIDTH = 200;
        final int DAY_HEIGHT = 150;

        /* Base Setup */

        this.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 2));

        this.setMinimumSize(new Dimension(baseWidth, baseHeight));
        this.setPreferredSize(new Dimension(baseWidth, baseHeight));
        this.setMaximumSize(new Dimension(baseWidth, baseHeight));

        for (int i = 0; i < 31; i++) this.add(new DayPanel(DAY_WIDTH, DAY_HEIGHT));
    }
}
