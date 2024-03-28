package windows.calendarWindow.panels.subpanels;

import jdk.jshell.execution.Util;
import utils.Utils;
import windows.calendarWindow.panels.subpanels.parts.LowerPart;
import windows.calendarWindow.panels.subpanels.parts.UpperPart;

import javax.swing.*;
import java.awt.*;

public class DayPanel extends JPanel {

    public DayPanel(int baseWidth, int baseHeight, String[] day, String[] monthAndYear){
        /* Variables */

        final int BASE_UPPER_HEIGHT = 40;

        /* Base Setup */

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;

        Utils.setupDimensions(this, new Dimension(baseWidth, baseHeight));

        this.setBorder(BorderFactory.createLineBorder(Color.black));

        /* Upper Part */

        JPanel upperPart = new UpperPart(this.getWidth(), BASE_UPPER_HEIGHT, day);
        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(upperPart, gbc);

        /* Lower Part */

        JPanel lowerPart = new LowerPart(this.getWidth(), this.getHeight()-BASE_UPPER_HEIGHT, day, monthAndYear);
        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(lowerPart, gbc);
    }
}
