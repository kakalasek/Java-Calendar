package utils;

import javax.swing.*;
import java.awt.*;

public class Utils {

    public static void setupDimensions(JComponent component, Dimension dimension){
        component.setMinimumSize(dimension);
        component.setPreferredSize(dimension);
        component.setMaximumSize(dimension);
    }

    public static String capitalize(String str){
        String capitalizedLetter = str.substring(0, 1).toUpperCase();

        return capitalizedLetter + str.substring(1);
    }
}
