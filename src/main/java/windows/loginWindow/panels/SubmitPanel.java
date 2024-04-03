package windows.loginWindow.panels;

import database.connection.DatabaseConnection;
import database.objects.user.User;
import database.objects.user.UserDaoImpl;
import exceptionHandler.ExceptionHandler;
import fileHandler.FileHandler;
import utils.Utils;
import windows.calendarWindow.Home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * A class which represent a panel with submitting login
 */
public class SubmitPanel extends JPanel{

    private final String noteFilepath = "src/main/notes/notes";

    public SubmitPanel(int baseWidth, int baseHeight, JTextField usernameField, JTextField passwordField){
        /* Constants */
        final int BUTTON_WIDTH = 100;
        final int BUTTON_HEIGHT = 40;

        /* Start Setup */
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        Utils.setupDimensions(this, new Dimension(baseWidth, baseHeight));

        /* Components */
        JButton submitButton = new JButton("Přihlásit");
        Utils.setupDimensions(submitButton, new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));

        submitButton.addActionListener(e -> {
            UserDaoImpl userDao = new UserDaoImpl();
            User user = new User(usernameField.getText(), passwordField.getText());

            if(DatabaseConnection.status > 0) { // Check if there is a database connection
                User compareUser = userDao.getByUsername(user.getUsername());   // Retrieve the user from database

                if (compareUser == null) {  // If the user does not exist on the database, create one and continue
                    userDao.save(user);
                } else {    // Else check if the password is correct
                    if(!user.getPassword().equals(compareUser.getPassword())){  // If the passwords don't match, do nothing
                        return;
                    }
                }
            }

            SwingUtilities.getWindowAncestor(this.getRootPane()).dispose();
            new Home(user);
        });

        this.add(submitButton);

        JButton clearButton = new JButton("C");
        Utils.setupDimensions(clearButton, new Dimension(45, BUTTON_HEIGHT));

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{

                    FileHandler.writeFile(noteFilepath, "", false);

                } catch (IOException e) {
                ExceptionHandler.log("Could not clear notes!\n" + e.getMessage() + "\n\n");
                ExceptionHandler.displayError("Write Error!");
            }
            }
        });

        this.add(clearButton);
    }
}
