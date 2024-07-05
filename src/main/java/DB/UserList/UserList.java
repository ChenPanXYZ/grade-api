package DB.UserList;

import entity.User;

import java.util.HashMap;
import java.util.Map;

import DB.Users;
import org.json.JSONObject;

/**
 * A map of username —> User object.
 */
// What do we gain by defining this class and storing an instance of it
// in the LogInUseCase class, as opposed to just
// storing a Map<String, User> in the LogInUseCase class?
public class UserList extends Users {

    private final Map<String, User> users = new HashMap<>();

    public UserList() {
        // for testing purposes (where sign up not yet implemented for this DB), add a user when creating this object.
        User user = new User("paul", "password", new JSONObject());
        users.put(user.getUsername(), user);
     }

    /**
     * Add user to this user list.
     * @param user the user to add
     */
    public void add(User user) {
        users.put(user.getUsername(), user);
    }

    /**
     * Return the User associated with username.
     * @param username the username of the user to get.
     */
    public User getUser(String username) {
        return users.get(username);
    }
}
