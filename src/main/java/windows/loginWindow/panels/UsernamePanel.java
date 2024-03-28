package windows.loginWindow.panels;

import utils.Utils;

import javax.swing.*;
import java.awt.*;

public class UsernamePanel extends JPanel {

    JTextField usernameField;

    public  UsernamePanel(int width, int height){
        /* Constants */

        final int FIELD_WIDTH = 220;
        final int FIELD_HEIGHT = 30;

        /* Setup */

        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        Utils.setupDimensions(this, new Dimension(width, height));

        JLabel usernameLabel = new JLabel("Zadejte uživatelské jméno:");
        this.add(usernameLabel);

        usernameField = new JTextField();

        Utils.setupDimensions(this, new Dimension(FIELD_WIDTH, FIELD_HEIGHT));
        this.add(usernameField);
    }

    public JTextField getUsernameField(){
        return usernameField;
    }
}
