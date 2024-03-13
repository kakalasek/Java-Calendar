package windows.panels;

import calendarHandler.CalendarHandler;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.util.*;

public class UpperPanel extends JPanel {

    public UpperPanel(int baseWidth, int baseHeight) {
        /* Variables */

        final String[][] monthsAndYears = CalendarHandler.getMonths();
        final String[] months = new String[12];

        for(int i = 0; i < 12; i++){
            months[i] = monthsAndYears[i][1] + " " + monthsAndYears[i][0];
        }

        final int MONTHS_BOX_WIDTH = 150;

        /* Base Setup */

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 40));

        this.setMinimumSize(new Dimension(baseWidth, baseHeight));
        this.setPreferredSize(new Dimension(baseWidth, baseHeight));
        this.setMaximumSize(new Dimension(baseWidth, baseHeight));

        this.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0,0,2, 0, Color.black), BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        /* Components */

        JComboBox<String> monthsBox = new JComboBox<>(months);
        monthsBox.setMinimumSize(new Dimension(MONTHS_BOX_WIDTH, 30));
        monthsBox.setPreferredSize(new Dimension(MONTHS_BOX_WIDTH, 30));
        monthsBox.setMaximumSize(new Dimension(MONTHS_BOX_WIDTH, 30));
        this.add(monthsBox);

    }
}
