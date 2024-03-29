package windows.calendarWindow;

import windows.calendarWindow.panels.CalendarPanel;
import windows.calendarWindow.panels.UpperPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * A class which represents the home window
 */
public class Home extends JFrame {

    public Home() throws IOException {
        /* Constants */
        final int BASE_WIDTH = 1500;
        final int UPPER_BASE_HEIGHT = 100;
        final int CALENDAR_BASE_HEIGHT = 800;

        /* Start Setup */
        this.setTitle("Kalendář");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

            /* Layout Setup */
            this.getContentPane().setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weightx = 1.0;

        /* Components */

            /* Initialize Panels */
            UpperPanel upperPanel = new UpperPanel(BASE_WIDTH, UPPER_BASE_HEIGHT);
            CalendarPanel calendarPanel = new CalendarPanel(BASE_WIDTH, CALENDAR_BASE_HEIGHT, upperPanel::getCurrentMonthYear);
            upperPanel.setCalendar(calendarPanel);

            /* Position UpperPanel */
            gbc.weighty = 0.0;
            gbc.gridx = 0;
            gbc.gridy = 0;
            this.getContentPane().add(upperPanel, gbc);

            /* Position CalendarPanel */
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
