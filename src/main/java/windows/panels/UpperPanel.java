package windows.panels;

import calendarHandler.CalendarHandler;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UpperPanel extends JPanel {

    public UpperPanel(int baseWidth, int baseHeight) {
        /* Variables */

        /* Base Setup */

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 40));

        this.setMinimumSize(new Dimension(baseWidth, baseHeight));
        this.setPreferredSize(new Dimension(baseWidth, baseHeight));
        this.setMaximumSize(new Dimension(baseWidth, baseHeight));

        this.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0,0,2, 0, Color.black), BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        /* Components */

        JComboBox<String> monthsBox = new JComboBox<>();
        monthsBox.setMinimumSize(new Dimension(100, 30));
        monthsBox.setPreferredSize(new Dimension(100, 30));
        monthsBox.setMaximumSize(new Dimension(100, 30));
        this.add(monthsBox);

        JComboBox<String> yearsBox = new JComboBox<>();
        yearsBox.setMinimumSize(new Dimension(100, 30));
        yearsBox.setPreferredSize(new Dimension(100, 30));
        yearsBox.setMaximumSize(new Dimension(100, 30));
        this.add(yearsBox);
    }
}