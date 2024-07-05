package DB.interfaces;
import entity.User;

public interface LoginInterface {
    /**
     * Return the User associated with username.
     * @param username the username of the user to get.
     */
    public User getUser(String username);
}
