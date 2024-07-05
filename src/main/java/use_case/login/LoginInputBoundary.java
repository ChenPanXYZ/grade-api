package use_case.login;
/**
 * The input boundary for the login use case.
 * So that it restricts the input of this usecase. Every implementation of this usecase must follow this input boundary.
 */
// Note: The interface that the LogInUseCase implements
// Note how it specifies what the input (arguments) and output (return type) are.
public interface LoginInputBoundary {
    LoginUseCase.LoginResult logIn(String username, String password);
}
