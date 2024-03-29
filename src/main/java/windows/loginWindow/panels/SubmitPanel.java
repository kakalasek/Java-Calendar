package windows.loginWindow.panels;

import utils.Utils;
import windows.calendarWindow.Home;

import javax.swing.*;
import java.awt.*;

/**
 * A class which represent a panel with submitting login
 */
public class SubmitPanel extends JPanel{

    public SubmitPanel(int baseWidth, int baseHeight, JTextField usernameField, JTextField passwordField){
        /* Constants */
        final int BUTTON_WIDTH = 100;
        final int BUTTON_HEIGHT = 40;

        /* Start Setup */
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        Utils.setupDimensions(this, new Dimension(baseWidth, baseHeight));

        /* Components */
        JButton submitButton = new JButton("Přihlásit");
        Utils.setupDimensions(submitButton, new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));

        submitButton.addActionListener(e -> {
            try {
                SwingUtilities.getWindowAncestor(this.getRootPane()).dispose();
                new Home();
            } catch(Exception ex){
                ex.printStackTrace();
            }
        });

        this.add(submitButton);

    }
}
