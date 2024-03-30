package exceptionHandler;

import fileHandler.FileHandler;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A class to handle all exception logging and keeping track on which exceptions occurred
 */
public class ExceptionHandler {

    private static JPanel errorPanel = null;    // A panel on which the error messages will be displayed
    private static ArrayList<String> errorMessages = new ArrayList<>(); // An array of all error messages, so each one will be displayed only once

    /* Logging File */
    private static final String logsFilePath = "src/main/logs/logs";

    /**
     * Used for logging. If the logging file is not found, it displays an error
     * @param message Message to be logged
     */
    public static void log(String message){
        try {
            FileHandler.writeFile(logsFilePath, message, true);
        } catch(IOException ex){
            displayError("Logging Error!");
        }
    }

    /**
     * Initializes the error panel
     * @param panel The panel to put the errors on
     */
    public static void initializeErrorPanel(JPanel panel){
        if(errorPanel == null) {
            errorPanel = panel;
            for (String errorMessage : errorMessages){  // Displays any error which appeared before the initialization

                JLabel errorLabel = new JLabel(errorMessage);
                errorLabel.setForeground(Color.red);
                errorPanel.add(errorLabel);
            }
        }
    }

    /**
     * Displays an error on the error panel. Saves the error if the panel is not yet initialized
     * @param errorMessage The text of the error
     */
    public static void displayError(String errorMessage){
        if(errorPanel == null) {
            if(errorMessages.contains(errorMessage)) return;
            errorMessages.add(errorMessage);

        }else {
            if(errorMessages.contains(errorMessage)) return;

            errorMessages.add(errorMessage);
            JLabel errorLabel = new JLabel(errorMessage);
            errorLabel.setForeground(Color.red);
            errorPanel.add(errorLabel);

        }
    }

    /**
     * Clear all logs, so they won't bloat your computer
     */
    public static void clearLogs(){
        try {
            FileHandler.writeFile(logsFilePath, "", false);
        } catch(IOException ex){
            displayError("Error clearing logs!");
        }
    }
}
