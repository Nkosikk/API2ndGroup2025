package PayloadBuilder;

import org.json.simple.JSONObject;

public class WeatherPayloadBuilder {
    public static JSONObject createWeatherPayload() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("q", "San Francisco Test Station");
        jsonObject.put("appid", "25267eac5de7343f868234b55039d9fc"); // Replace with your actual API key
        jsonObject.put("units", "metric");

        return jsonObject;
    }
}
