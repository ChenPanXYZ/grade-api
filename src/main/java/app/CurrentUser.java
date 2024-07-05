package app;
import entity.User;
/**
 * A global variable to store the current user status.
 * TODO: how to improve this class, any better way to carry the user information that complies with CA?
 */

public class CurrentUser {

    private static CurrentUser instance;
    private User user;

    // Private constructor to prevent instantiation
    private CurrentUser() {
    }

    // Static method to get the single instance of the class
    public static CurrentUser getInstance() {
        if (instance == null) {
            instance = new CurrentUser();
        }
        return instance;
    }

    // Getter and Setter for the global variable
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
