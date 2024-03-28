package windows.loginWindow.panels;

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

        this.setMinimumSize(new Dimension(width, height));
        this.setPreferredSize(new Dimension(width, height));
        this.setMaximumSize(new Dimension(width, height));

        JLabel usernameLabel = new JLabel("Zadejte uživatelské jméno:");
        this.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setMinimumSize(new Dimension(FIELD_WIDTH, FIELD_HEIGHT));
        usernameField.setPreferredSize(new Dimension(FIELD_WIDTH, FIELD_HEIGHT));
        usernameField.setMaximumSize(new Dimension(FIELD_WIDTH, FIELD_HEIGHT));
        this.add(usernameField);

    }

    public JTextField getUsernameField(){
        return usernameField;
    }
}
