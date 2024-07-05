package app;
import DB.UserList.UserList;
import controller.CheckInfoController;
import controller.LoginController;
import DB.MongoDBUserList.MongoDBUserList;
import DB.Users;
import use_case.checkInfo.CheckInfoInputBoundary;
import use_case.checkInfo.CheckInfoUseCase;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginUseCase;

public class Config {
    // Defining different versions of implementations without breaking the code. Seperating into controllers and usecases of single responsibilities.
    private final Users users = new UserList();
    // private final Users users = new MongoDBUserList();
    private final LoginInputBoundary loginUseCase = new LoginUseCase(users, CurrentUser.getInstance());
    private final CheckInfoInputBoundary checkInfoUseCase = new CheckInfoUseCase(CurrentUser.getInstance());
    public LoginController loginController() {
        return new LoginController(loginUseCase);
    }
    public CheckInfoController checkInfoController() {return new CheckInfoController(checkInfoUseCase);}

}
