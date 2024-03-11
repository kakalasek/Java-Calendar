package windows.calendarPanel;

import javax.swing.*;
import java.awt.*;

public class CalendarPanel extends JPanel {

    public CalendarPanel(LayoutManager layoutManager, int baseWidth, int baseHeight){
        this.setLayout(layoutManager);

        this.setBackground(Color.blue);
        this.setMinimumSize(new Dimension(baseWidth, baseHeight));
        this.setPreferredSize(new Dimension(baseWidth, baseHeight));
        this.setMaximumSize(new Dimension(baseWidth, baseHeight));
    }
}
