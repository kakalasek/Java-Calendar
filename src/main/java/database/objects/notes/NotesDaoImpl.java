package database.objects.notes;

import database.connection.DatabaseConnection;
import exceptionHandler.ExceptionHandler;
import windows.calendarWindow.Home;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;

public class NotesDaoImpl implements NotesDao{

    private final String notesTableName = "notes";

    @Override
    public Notes getAllByUser(String username) {
        Notes notes = new Notes();

        String select = "SELECT identifier, note FROM ? WHERE user_id = (SELECT id FROM users WHERE username = ?)";

        try(PreparedStatement ps = DatabaseConnection.prepareStatement(select)){

            ps.setString(1, notesTableName);
            ps.setString(2, Home.currentUser.getUsername());

            try(ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    notes.put(rs.getString("identifier"), rs.getString("note"));
                }
            }

        } catch (NullPointerException | SQLException e) {
            ExceptionHandler.log("Failed to prepare statement!\n" + e.getMessage() + "\n\n");
            throw new RuntimeException(e);
        }

        return notes;
    }

    @Override
    public void saveAll(Notes notes) {

        String insert = "INSERT INTO ?(user_id, note, identifier) VALUES ((SELECT id FROM users WHERE username = ?), ?, ?) " +
                "ON DUPLICATE KEY UPDATE note=?";

        try(PreparedStatement ps = DatabaseConnection.prepareStatement(insert)){

            ps.setString(1, notesTableName);
            ps.setString(2, Home.currentUser.getUsername());

            for (Map.Entry<String, String> entry : notes.entrySet()) {
                String k = entry.getKey();
                String v = entry.getValue();

                ps.setString(3, v);
                ps.setString(4, k);
                ps.setString(5, v);

                ps.execute();
            }

        } catch (NullPointerException | SQLException e){
            ExceptionHandler.log("Failed to prepare statement!\n" + e.getMessage() + "\n\n");
            throw new RuntimeException(e);
        }
    }
}
