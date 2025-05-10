package PayloadBuilder;

import org.json.simple.JSONObject;

public class OpenWeatherPayloadBuilder {
    public static JSONObject createWeatherResponse(){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "employeeName");
        jsonObject.put("job","jobTitle");

        return jsonObject;
    }
}
