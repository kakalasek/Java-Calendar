package utils;

import javax.swing.*;
import java.awt.*;

/**
 * A class which handles any special operations that can be simplified by a function
 */
public class Utils {

    /**
     * Setups all sizes for a JComponent
     * @param component The component to set up the sizes for
     * @param dimension The sizes
     */
    public static void setupDimensions(JComponent component, Dimension dimension){
        component.setMinimumSize(dimension);
        component.setPreferredSize(dimension);
        component.setMaximumSize(dimension);
    }

    /**
     * Capitalizes the first letter of a string
     * @param str String to be capitalized
     * @return The capitalized string
     */
    public static String capitalize(String str){
        String capitalizedLetter = str.substring(0, 1).toUpperCase();

        return capitalizedLetter + str.substring(1);
    }
}
