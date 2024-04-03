package database.objects.user;

import database.connection.DatabaseConnection;
import exceptionHandler.ExceptionHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A class which holds method to get and insert user to database
 */
public class UserDaoImpl implements UserDao{

    /**
     * Retrieves a user from database by its username
     * @param username  Username of the user we want to get
     * @return Either the user, or null if the user does not exist
     */
    @Override
    public User getByUsername(String username) {
        User user = null;

        String select = "SELECT * FROM users WHERE username = ?";

        try(PreparedStatement ps = DatabaseConnection.prepareStatement(select)){

            ps.setString(1, username);

           try(ResultSet rs = ps.executeQuery()) {

               if (rs.next()) {
                   user = new User(rs.getString("username"), rs.getString("password"));
               }

           }

        } catch (NullPointerException | SQLException e) {
            ExceptionHandler.log("Failed to prepare statement!\n" + e.getMessage() + "\n\n");
            throw new RuntimeException(e);
        }

        return user;
    }

    /**
     * Saves the user to database
     * @param user User to be saved
     */
    @Override
    public void save(User user) {
        String insert = "INSERT INTO users(username, password) VALUES (?,?)";

        try(PreparedStatement ps = DatabaseConnection.prepareStatement(insert)){
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());

            ps.execute();

        } catch(NullPointerException | SQLException e){
            ExceptionHandler.log("Failed to prepare statement!\n" + e.getMessage() + "\n\n");
            throw new RuntimeException(e);
        }
    }
}
