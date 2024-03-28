package database.objects.user;

import java.util.Optional;

public class UserDaoImpl implements UserDao{
    @Override
    public Optional<User> getByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public void save(User user) {

    }
}
