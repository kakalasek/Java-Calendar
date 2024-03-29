package windows.loginWindow.panels;

import utils.Utils;

import javax.swing.*;
import java.awt.*;

/**
 * A class which represents a panel with password input
 */
public class PasswordPanel extends JPanel{

    /* Components used outside the constructor */
    private final JTextField passwordField;

    public PasswordPanel(int baseWidth, int baseHeight){
        /* Constants */
        final int FIELD_WIDTH = 220;
        final int FIELD_HEIGHT = 30;

        /* Setup Setup */
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        Utils.setupDimensions(this, new Dimension(baseWidth, baseHeight));


        /* Components */
        JLabel usernameLabel = new JLabel("Zadejte heslo:");
        this.add(usernameLabel);

        passwordField = new JTextField();
        Utils.setupDimensions(passwordField, new Dimension(FIELD_WIDTH, FIELD_HEIGHT));
        this.add(passwordField);

    }

    /* Methods */
    public JTextField getPasswordField(){
        return passwordField;
    }
}
