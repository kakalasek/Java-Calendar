package windows.loginWindow.panels;

import utils.Utils;
import windows.calendarWindow.Home;

import javax.swing.*;
import java.awt.*;

public class SubmitPanel extends JPanel{

    public SubmitPanel(int width, int height, JTextField usernameField, JTextField passwordField){
        /* Constants */

        final int BUTTON_WIDTH = 100;
        final int BUTTON_HEIGHT = 40;

        /* Setup */

        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        Utils.setupDimensions(this, new Dimension(width, height));

        JButton submitButton = new JButton("Přihlásit");

        Utils.setupDimensions(submitButton, new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));

        submitButton.addActionListener(e -> {
            SwingUtilities.getWindowAncestor(this.getRootPane()).dispose();
            new Home();
        });

        this.add(submitButton);


    }
}
