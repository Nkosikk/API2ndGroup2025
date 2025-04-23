package PayloadBuilder;

import org.json.simple.JSONObject;

public class OpenWeatherPayloadBuilder {

    public static JSONObject createNewWeatherStationObject() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "API Test");
        jsonObject.put("external_id", "Test101");
        jsonObject.put("latitude",50.50 );
        jsonObject.put("longitude",-155.65 );
        jsonObject.put("altitude",200 );

        return jsonObject;
    }
}
