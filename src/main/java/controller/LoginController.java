package controller;

import use_case.login.LoginInputBoundary;
import use_case.login.LoginUseCase;

/**
 * Controls the process for logging in.
 */
// If we handled logging out as well, this would be a good controller
// to do it in. It could have runLogin and runLogout methods.
public class LoginController {

    /**
     * The input boundary for the login use case.
     */
    private final LoginInputBoundary loginInputBoundary;

    /**
     * A new LoginController for the use case defined by the LoginInputBoundary.
     * @param loginInputBoundary the input boundary for the login use case
     */
    public LoginController(LoginInputBoundary loginInputBoundary) {
        this.loginInputBoundary = loginInputBoundary;
    }

    /**
     * Run the login use case where username is attempting to log into their
     * account with a password attempt.
     * @param username the username
     * @param password the password attempt
     */
    public LoginUseCase.LoginResult runLogin(String username, String password) {
        return loginInputBoundary.logIn(username, password);
    }
}