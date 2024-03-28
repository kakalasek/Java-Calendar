package windows.calendarWindow.panels;

import calendarHandler.CalendarHandler;
import utils.Utils;
import windows.calendarWindow.panels.subpanels.DayPanel;

import javax.swing.*;
import java.awt.*;
import java.util.function.Supplier;

public class CalendarPanel extends JPanel {

    private final Supplier<String[]> getMonthYear;
    private final int DAY_WIDTH = 200;
    private final int DAY_HEIGHT = 150;
    private String currentMonth;
    private int currentYear;
    public CalendarPanel(int baseWidth, int baseHeight, Supplier<String[]> getMonthYear){
        /* Variables */

        this.getMonthYear = getMonthYear;
        this.currentMonth = getMonthYear.get()[0];
        this.currentYear = Integer.parseInt(getMonthYear.get()[1]);

        /* Base Setup */

        this.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 2));

        Utils.setupDimensions(this, new Dimension(baseWidth, baseHeight));

        for(int i = 0; i < CalendarHandler.getDaysInMonth(currentMonth, currentYear); i++){
            this.add(new DayPanel(DAY_WIDTH, DAY_HEIGHT, new String[]{String.valueOf(i+1), CalendarHandler.getDayOfWeek(i+1, currentMonth, currentYear)}, getMonthYear.get()));
        }
    }

    public void reset(){
        this.removeAll();

        this.currentMonth = getMonthYear.get()[0];
        this.currentYear = Integer.parseInt(getMonthYear.get()[1]);

        for(int i = 0; i < CalendarHandler.getDaysInMonth(currentMonth, currentYear); i++){
            this.add(new DayPanel(DAY_WIDTH, DAY_HEIGHT, new String[]{String.valueOf(i+1), CalendarHandler.getDayOfWeek(i+1, currentMonth, currentYear)}, getMonthYear.get()));
        }

        this.revalidate();
        this.repaint();
    }
}
