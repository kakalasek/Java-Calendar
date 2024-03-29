package windows.loginWindow;

import windows.loginWindow.panels.PasswordPanel;
import windows.loginWindow.panels.SubmitPanel;
import windows.loginWindow.panels.UsernamePanel;

import javax.swing.*;
import java.awt.*;

/**
 * A class which represents the login window
 */
public class Login extends JFrame {


    public Login(){

        /* Constants */
        final int BASE_WIDTH = 300;
        final int PART_BASE_HEIGHT = 100;

        /* Start Setup */
        this.setTitle("Přilášení");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 1));

        /* Components */
        UsernamePanel usernamePanel = new UsernamePanel(BASE_WIDTH, PART_BASE_HEIGHT);
        this.add(usernamePanel);

        PasswordPanel passwordPanel = new PasswordPanel(BASE_WIDTH, PART_BASE_HEIGHT);
        this.add(passwordPanel);

        SubmitPanel submitPanel = new SubmitPanel(BASE_WIDTH, PART_BASE_HEIGHT, usernamePanel.getUsernameField(), passwordPanel.getPasswordField());
        this.add(submitPanel);

        /* End Setup */
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
}
