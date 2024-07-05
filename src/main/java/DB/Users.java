package DB;
import entity.User;
/**
 * An abstract class that specifies the methods that a user DB implementation should have.
 * Note that here we show a text-based implementation of the user DB, as well as a mongodb implementation.
 */

public abstract class Users {
    /**
     * Add user to this user list.
     * @param user the user to add
     */
    public abstract void add(User user);
    /**
     * Return the User associated with username.
     * @param username the username of the user to get.
     */
    public abstract User getUser(String username);
}
