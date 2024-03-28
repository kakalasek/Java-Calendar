package database.objects.user;

import java.util.Optional;

public interface UserDao {
    Optional<User> getByUsername(String username);
    void save(User user);
}
