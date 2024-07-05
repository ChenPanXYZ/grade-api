package DB.MongoDBUserList;
import entity.User;

import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import DB.Users;

public class MongoDBUserList extends Users {
    @Override
    public void add(User user) throws JSONException {
    }

    public User getUser(String username) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(String.format("https://grade-logging-api.chenpan.ca/student?username=%s", username))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();

            JSONObject responseBody = new JSONObject(response.body().string());

            System.out.println(responseBody);

            if (responseBody.getInt("status_code") == 200) {
                JSONObject user = responseBody.getJSONObject("student");
                return new User(user.getString("username"), user.getString("password"), user.getJSONObject("additionalInformation"));
            } else {
                throw new RuntimeException(responseBody.getString("message"));
            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
