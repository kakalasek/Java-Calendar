package windows.loginWindow;

import windows.loginWindow.panels.PasswordPanel;
import windows.loginWindow.panels.UsernamePanel;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    public Login(){
        /* Constants */
        final int BASE_WIDTH = 500;
        final int PART_BASE_HEIGHT = 250;

        /* Config */

        this.setTitle("Přilášení");

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setLayout(new GridLayout(2, 1));

        UsernamePanel usernamePanel = new UsernamePanel(BASE_WIDTH, PART_BASE_HEIGHT);
        this.add(usernamePanel);

        PasswordPanel passwordPanel = new PasswordPanel(BASE_WIDTH, PART_BASE_HEIGHT);
        this.add(passwordPanel);

        this.pack();

        this.setLocationRelativeTo(null);

        this.setVisible(true);
    }
}
