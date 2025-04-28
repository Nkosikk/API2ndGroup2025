package PayloadBuilder;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class WeatherStationPayloadBuilder {

//    method to create object for the payload,
//    using the json simple library instead of string
//    populate object with information, that is keys and the values of the keys
//    jsonObject.put("key", "value"); // Adds a key-value pair to the JSON object
       @Test
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
    }





