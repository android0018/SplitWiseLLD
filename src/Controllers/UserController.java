package Controllers;

import User.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    List<User> users;
    public UserController() {
        users=new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User getUser(int userId) {
        for(User user:users){
            if (user.getUserId()==userId){
                return user;
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
        return users;
    }
}
