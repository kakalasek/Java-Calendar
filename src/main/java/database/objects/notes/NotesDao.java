package database.objects.notes;

import java.util.Optional;

public interface NotesDao {

    Optional<Notes> getAllByUser(String username);

    void saveAll(Notes notes);
}
