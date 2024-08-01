package pre;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class JSONObjectReader {

    public JSONObject jsonObject;
    private JSONObjectReader() {
        try {
            // Read the JSON file as a string.
            // Note that it will be the same format as many API responses.
            String jsonString = new String(Files.readAllBytes(Paths.get("./sample.json")));
            this.jsonObject = new JSONObject(jsonString);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObjectReader getCanadaFrenchTranslation() {
        JSONObjectReader jsonObjectReader = new JSONObjectReader();
        // this is alreaddy an array.
        // get the 30th element of the array

        JSONObject canadaFrenchTranslation = jsonObjectReader.jsonObject.getJSONArray("translations").getJSONObject(29);
    }
    public static void main(String[] args) {
        JSONObjectReader jsonObjectReader = new JSONObjectReader();
        // Reading the data from JSON object
        String name = jsonObjectReader.jsonObject.getString("name");
        int age = jsonObjectReader.jsonObject.getInt("age");
        String city = jsonObjectReader.jsonObject.getString("city");

        // Print the values
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("City: " + city);
    }
}