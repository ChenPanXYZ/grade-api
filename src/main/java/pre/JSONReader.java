package pre;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONReader {

    public JSONArray jsonObject;
    public JSONReader() {
        try {
            // Read the JSON file as a string.
            // Question: Is this an array or an object?
            String jsonString = new String(Files.readAllBytes(Paths.get("./sample.json")));
            this.jsonObject = new JSONArray(jsonString);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getCanadaCountryNameSpanishTranslation() {
        // get the 30th element in the array.
        JSONArray jsonArray = this.jsonObject;


        // Note that an element of this array is a JSONObject, which is in the same format as MANY API responses.
        JSONObject canada = jsonArray.getJSONObject(30);
        String nameInFrench = canada.getString("es");
        return nameInFrench;
    }

    /**
     * JSONReader Exercise.
     * @param countryName the name of the country, in two letters.
     * @param language the language to translate to, in two letters.
     */
    public String getCountryNameTranslation(String countryName, String language) {
        JSONArray jsonArray = this.jsonObject;
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject country = jsonArray.getJSONObject(i);
            if (country.getString("alpha2").equals(countryName)) {
                return country.getString(language);
            }
        }
        return "Country not found";
    }

    public static void main(String[] args) {
        JSONReader jsonReader = new JSONReader();

        jsonReader.getCanadaCountryNameSpanishTranslation();
        String translation = jsonReader.getCountryNameTranslation("ca", "es");
        System.out.println(translation);
    }
}