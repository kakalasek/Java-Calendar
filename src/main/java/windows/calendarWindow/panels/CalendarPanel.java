package windows.calendarWindow.panels;

import calendarHandler.CalendarHandler;
import utils.Utils;
import windows.calendarWindow.panels.subpanels.DayPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.function.Supplier;

/**
 * A class which represents a panel with the calendar days
 */
public class CalendarPanel extends JPanel {

    /* Components and constants used outside the constructor */
    private final Supplier<String[]> getMonthYear;
    private final int DAY_WIDTH = 200;
    private final int DAY_HEIGHT = 150;
    private String currentMonth;
    private int currentYear;

    public CalendarPanel(int baseWidth, int baseHeight, Supplier<String[]> getMonthYear) {
        /* Constants */
        this.getMonthYear = getMonthYear;
        this.currentMonth = getMonthYear.get()[0];
        this.currentYear = Integer.parseInt(getMonthYear.get()[1]);

        /* Base Setup */
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 2));
        Utils.setupDimensions(this, new Dimension(baseWidth, baseHeight));

        /* Components */
        for(int i = 0; i < CalendarHandler.getDaysInMonth(currentMonth, currentYear); i++){
            this.add(new DayPanel(DAY_WIDTH, DAY_HEIGHT, new String[]{String.valueOf(i+1), CalendarHandler.getDayOfWeek(i+1, currentMonth, currentYear)}, getMonthYear.get()));
        }
    }

    /* Methods */

    /**
     * Resets the day panels, when month is changed
     */
    public void reset() {
        this.removeAll();   // First remove all current ones

        this.currentMonth = getMonthYear.get()[0];  // Get the selected month
        this.currentYear = Integer.parseInt(getMonthYear.get()[1]); // Get the selected year

        // Create the new day panels
        for(int i = 0; i < CalendarHandler.getDaysInMonth(currentMonth, currentYear); i++){
            this.add(new DayPanel(DAY_WIDTH, DAY_HEIGHT, new String[]{String.valueOf(i+1), CalendarHandler.getDayOfWeek(i+1, currentMonth, currentYear)}, getMonthYear.get()));
        }

        // Render the new day panels
        this.revalidate();
        this.repaint();
    }
}
