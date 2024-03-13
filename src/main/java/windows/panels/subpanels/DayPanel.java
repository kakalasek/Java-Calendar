package windows.panels.subpanels;

import windows.panels.subpanels.parts.LowerPart;
import windows.panels.subpanels.parts.UpperPart;

import javax.swing.*;
import java.awt.*;

public class DayPanel extends JPanel {

    public DayPanel(int baseWidth, int baseHeight){
        /* Variables */

        final int BASE_UPPER_HEIGHT = 40;

        /* Base Setup */

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;

        this.setMinimumSize(new Dimension(baseWidth, baseHeight));
        this.setPreferredSize(new Dimension(baseWidth, baseHeight));
        this.setMaximumSize(new Dimension(baseWidth, baseHeight));

        this.setBorder(BorderFactory.createLineBorder(Color.black));

        /* Upper Part */

        JPanel upperPart = new UpperPart(this.getWidth(), BASE_UPPER_HEIGHT);
        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(upperPart, gbc);

        /* Lower Part */

        JPanel lowerPart = new LowerPart(this.getWidth(), this.getHeight()-BASE_UPPER_HEIGHT);
        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(lowerPart, gbc);
    }
}
