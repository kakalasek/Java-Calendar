package database.objects.notes;

import java.util.Optional;

public class NotesDaoImpl implements NotesDao{
    @Override
    public Optional<Notes> getAllByUser(String username) {
        return Optional.empty();
    }

    @Override
    public void saveAll(Notes notes) {

    }
}
