package PayloadBuilder;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class WeatherStationPayloadBuilder {

//    method to create object for the payload,
//    using the json simple library instead of string
//    populate object with information, that is keys and the values of the keys
//    jsonObject.put("key", "value"); // Adds a key-value pair to the JSON object

        public static JSONObject createWeatherStationPayload() {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("external_id", "MM_TEST001");
            jsonObject.put("name", "Matjila Test Station");
            jsonObject.put("latitude", 47.76);
            jsonObject.put("longitude", -122.43);
            jsonObject.put("altitude", 150);

            //System.out.println("Weather Station Payload: " + jsonObject);
            return jsonObject;

        }

    public static JSONObject updateWeatherStationPayload() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("external_id", "Test101");
        jsonObject.put("name", "Updated Station");
        jsonObject.put("latitude", -26.2041);
        jsonObject.put("longitude", 28.0473);
        jsonObject.put("altitude", 1550);
        return jsonObject;
    }

    public static JSONObject deleteWeatherStationPayload() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("external_id", "Test101"); // Example key-value pair
        return jsonObject;
    }
    }





