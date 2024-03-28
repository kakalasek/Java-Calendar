package windows.loginWindow.panels;

import javax.swing.*;
import java.awt.*;

public class PasswordPanel extends JPanel{

    JTextField passwordField;

    public PasswordPanel(int width, int height){
        /* Constants */

        final int FIELD_WIDTH = 220;
        final int FIELD_HEIGHT = 30;

        /* Setup */

        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        this.setMinimumSize(new Dimension(width, height));
        this.setPreferredSize(new Dimension(width, height));
        this.setMaximumSize(new Dimension(width, height));

        JLabel usernameLabel = new JLabel("Zadejte heslo:");
        this.add(usernameLabel);

        passwordField = new JTextField();
        passwordField.setMinimumSize(new Dimension(FIELD_WIDTH, FIELD_HEIGHT));
        passwordField.setPreferredSize(new Dimension(FIELD_WIDTH, FIELD_HEIGHT));
        passwordField.setMaximumSize(new Dimension(FIELD_WIDTH, FIELD_HEIGHT));
        this.add(passwordField);

    }

    public JTextField getPasswordField(){
        return passwordField;
    }
}
