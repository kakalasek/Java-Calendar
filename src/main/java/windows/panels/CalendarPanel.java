package windows.panels;

import calendarHandler.CalendarHandler;
import windows.panels.subpanels.DayPanel;

import javax.swing.*;
import java.awt.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class CalendarPanel extends JPanel {

    private Supplier<String[]> getMonthYear;
    private String currentMonth;
    private int currentYear;

    private final int DAY_WIDTH = 200;
    private final int DAY_HEIGHT = 150;

    public CalendarPanel(int baseWidth, int baseHeight, Supplier<String[]> getMonthYear){
        /* Variables */

        this.getMonthYear = getMonthYear;

        this.currentMonth = getMonthYear.get()[0];
        this.currentYear = Integer.parseInt(getMonthYear.get()[1]);

        /* Base Setup */

        this.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 2));

        this.setMinimumSize(new Dimension(baseWidth, baseHeight));
        this.setPreferredSize(new Dimension(baseWidth, baseHeight));
        this.setMaximumSize(new Dimension(baseWidth, baseHeight));

        for(int i = 0; i < CalendarHandler.getDaysInMonth(currentMonth, currentYear); i++){
            this.add(new DayPanel(DAY_WIDTH, DAY_HEIGHT, new String[]{String.valueOf(i+1), CalendarHandler.getDayOfWeek(i+1, currentMonth, currentYear)}));
        }
    }

    public void reset(){
        this.removeAll();
        this.currentMonth = getMonthYear.get()[0];
        this.currentYear = Integer.parseInt(getMonthYear.get()[1]);

        for(int i = 0; i < CalendarHandler.getDaysInMonth(currentMonth, currentYear); i++){
            this.add(new DayPanel(DAY_WIDTH, DAY_HEIGHT, new String[]{String.valueOf(i+1), CalendarHandler.getDayOfWeek(i+1, currentMonth, currentYear)}));
        }

        this.revalidate();
        this.repaint();
    }
}
