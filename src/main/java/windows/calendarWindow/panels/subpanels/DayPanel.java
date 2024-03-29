package windows.calendarWindow.panels.subpanels;

import utils.Utils;
import windows.calendarWindow.panels.subpanels.parts.LowerPart;
import windows.calendarWindow.panels.subpanels.parts.UpperPart;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * A class which represent a panel for one specific day in month
 */
public class DayPanel extends JPanel {

    public DayPanel(int baseWidth, int baseHeight, String[] day, String[] monthAndYear) throws IOException {
        /* Constants */
        final int BASE_UPPER_HEIGHT = 40;

        /* Start Setup */
        Utils.setupDimensions(this, new Dimension(baseWidth, baseHeight));
        this.setBorder(BorderFactory.createLineBorder(Color.black));

            /* Layout Setup */
            this.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weightx = 1.0;

        /* Components */

            /* Upper Part Setup */

            JPanel upperPart = new UpperPart(this.getWidth(), BASE_UPPER_HEIGHT, day);
            gbc.weighty = 0.0;
            gbc.gridx = 0;
            gbc.gridy = 0;
            this.add(upperPart, gbc);

            /* Lower Part Setup */

            JPanel lowerPart = new LowerPart(this.getWidth(), this.getHeight()-BASE_UPPER_HEIGHT, day, monthAndYear);
            gbc.weighty = 1.0;
            gbc.gridx = 0;
            gbc.gridy = 1;
            this.add(lowerPart, gbc);

    }
}
