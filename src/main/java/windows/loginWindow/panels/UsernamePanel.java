package windows.loginWindow.panels;

import utils.Utils;

import javax.swing.*;
import java.awt.*;

/**
 * A class which represents a panel with username input
 */
public class UsernamePanel extends JPanel {

    /* Components used outside the constructor */
    JTextField usernameField;

    public  UsernamePanel(int baseWidth, int baseHeight){
        /* Constants */
        final int FIELD_WIDTH = 220;
        final int FIELD_HEIGHT = 30;

        /* Start Setup */
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        Utils.setupDimensions(this, new Dimension(baseWidth, baseHeight));

        /* Components */
        JLabel usernameLabel = new JLabel("Zadejte uživatelské jméno:");
        this.add(usernameLabel);

        usernameField = new JTextField();
        Utils.setupDimensions(usernameField, new Dimension(FIELD_WIDTH, FIELD_HEIGHT));
        this.add(usernameField);

    }

    /* Methods */
    public JTextField getUsernameField(){
        return usernameField;
    }
}
