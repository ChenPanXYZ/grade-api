package DB.interfaces;

import entity.User;

public interface SignupInterface {
    /**
     * Return the User associated with username.
     * @param user the username of the user to get.
     */
    public void add(User user);
}
