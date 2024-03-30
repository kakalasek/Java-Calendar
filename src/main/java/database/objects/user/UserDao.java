package database.objects.user;

/**
 * Self-explanatory
 */
public interface UserDao {
    User getByUsername(String username);
    void save(User user);
}
