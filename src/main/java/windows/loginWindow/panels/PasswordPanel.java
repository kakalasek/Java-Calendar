package windows.loginWindow.panels;

import javax.swing.*;
import java.awt.*;

public class PasswordPanel extends JPanel{

    public PasswordPanel(int width, int height){

        this.setMinimumSize(new Dimension(width, height));
        this.setPreferredSize(new Dimension(width, height));
        this.setMaximumSize(new Dimension(width, height));
    }
}
