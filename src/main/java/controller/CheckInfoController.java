package controller;
import org.json.JSONObject;
import use_case.checkInfo.CheckInfoInputBoundary;

/**
 * Controls the process for checking user's information.
 */

public class CheckInfoController {

    /**
     * The input boundary for the check user's information case.
     */
    private final CheckInfoInputBoundary checkInfoInputBoundary;

    /**
     * A new CheckInfoController for the use case defined by the CheckInfoController.
     * @param checkInfoInputBoundary the input boundary for the check info use case
     */
    public CheckInfoController(CheckInfoInputBoundary checkInfoInputBoundary) {
        this.checkInfoInputBoundary = checkInfoInputBoundary;
    }

    /**
     * Run the check info use case where user is trying to retrieve their information.
     */
    public JSONObject runCheck() {
        return checkInfoInputBoundary.check();
    }
}