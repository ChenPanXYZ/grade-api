package use_case.checkInfo;
import app.CurrentUser;
import org.json.JSONObject;

public class CheckInfoUseCase implements CheckInfoInputBoundary {
    private final CurrentUser CurrentUser;

    public CheckInfoUseCase(app.CurrentUser currentUser) {
        CurrentUser = currentUser;
    }

    @Override
    public JSONObject check() {
        // check if currentUser.getUser() is null
        // Logic: if it is null, we return a null JSONObject.
        if (CurrentUser.getUser() == null) {
            return null;
        }
        else {
            return CurrentUser.getUser().getAdditionalInfo();
        }

    }
}
