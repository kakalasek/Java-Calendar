package database.objects.user;

import java.util.Optional;

public class User{
    private String username;
    private String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
}
