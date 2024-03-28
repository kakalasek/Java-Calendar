package windows.loginWindow.panels;

import windows.calendarWindow.Home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubmitPanel extends JPanel{

    public SubmitPanel(int width, int height, JTextField usernameField, JTextField passwordField){
        /* Constants */

        final int BUTTON_WIDTH = 100;
        final int BUTTON_HEIGHT = 40;

        /* Setup */

        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        this.setMinimumSize(new Dimension(width, height));
        this.setPreferredSize(new Dimension(width, height));
        this.setMaximumSize(new Dimension(width, height));

        JButton submitButton = new JButton("Přihlásit");
        submitButton.setMinimumSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        submitButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        submitButton.setMaximumSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));

        submitButton.addActionListener(e -> {
            System.out.println(usernameField.getText() + " " + passwordField.getText());
            SwingUtilities.getWindowAncestor(this.getRootPane()).dispose();
            new Home();
        });

        this.add(submitButton);


    }
}
