package use_case.login;

import app.CurrentUser;
import entity.User;

import DB.Users;

public class LoginUseCase implements LoginInputBoundary {

    /**
     * Users databases.
     */
    private final Users users;
    private final CurrentUser CurrentUser;

//    /**
//     * Serializes and deserializes list of users
//     */
//    UserReadWriter readWriter = new UserReadWriter();
//    //TODO: inject this object and change the type to ReadWriter interface.

    /**
     * / The "output" of this use case.
     */
    // Note: This could also be a fully-fledged class if we need to return
    // information to the controller.
    public enum LoginResult {
        SUCCESS, FAILURE // Should we do NO_SUCH_USER as well as SUCCESS and FAILURE?
    }

    public LoginUseCase(Users users, CurrentUser currentUser) {
        this.users = users;
        this.CurrentUser = currentUser;
    }

    /**
     * Run the login use case.
     * @param username the username
     * @param password the password attempt
     * @return whether the attempt matches the password associated with username
     */
    public LoginResult logIn(String username, String password) {
        User user = users.getUser(username);
        if (user.passwordMatches(password)) {
            CurrentUser.setUser(user);

            return LoginResult.SUCCESS;
        } else {
            return LoginResult.FAILURE;
        }
    }
}