package windows;

import windows.calendarPanel.CalendarPanel;
import windows.calendarPanel.UpperPanel;

import javax.swing.*;
import java.awt.*;

public class Home extends JFrame {

    public Home(){
        /* Constants */

        final int BASE_WIDTH = 1200;
        final int UPPER_BASE_HEIGHT = 100;
        final int CALENDAR_BASE_HEIGHT = 700;

        /* Pre Setup */

        this.setTitle("Home");

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        /* Panels */

        // Setup

        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;

        // Upper Panel

        JPanel upperPanel = new UpperPanel(new FlowLayout(), BASE_WIDTH, UPPER_BASE_HEIGHT);
        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.getContentPane().add(upperPanel, gbc);

        // Calendar

        JPanel calendarPanel = new CalendarPanel(new GridBagLayout(), BASE_WIDTH, CALENDAR_BASE_HEIGHT);
        calendarPanel.setMinimumSize(new Dimension(BASE_WIDTH, CALENDAR_BASE_HEIGHT));
        calendarPanel.setPreferredSize(new Dimension(BASE_WIDTH, CALENDAR_BASE_HEIGHT));
        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.getContentPane().add(calendarPanel, gbc);

        /* End Setup */

        this.pack();

        this.setLocationRelativeTo(null);

        this.setVisible(true);
    }
}
