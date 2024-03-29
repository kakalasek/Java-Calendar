package windows.calendarWindow.panels.subpanels.parts;

import utils.Utils;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class UpperPart extends JPanel {

    public UpperPart(int baseWidth, int baseHeight, String[] day){
        /* Start Setup */
        this.setLayout(new BorderLayout());
        Utils.setupDimensions(this, new Dimension(baseWidth, baseHeight));
        this.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0,0,2, 0, Color.black), BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        /* Components */
        JLabel dayOfWeek = new JLabel(day[0]);
        this.add(dayOfWeek, BorderLayout.WEST);

        JLabel dayInMonth = new JLabel(day[1]);
        this.add(dayInMonth, BorderLayout.EAST);

    }
}
