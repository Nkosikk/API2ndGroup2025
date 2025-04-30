package PayloadBuilder;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;


public class OpenWeatherPayloadBuilder {

    private static final String BASE_URL = "https://api.openweathermap.org";
    private static final String API_KEY = "1589ee5727295072e2272d60dfc6904";


    public static JSONObject createNewWeatherStationObject() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("external_id", "Test101");
        jsonObject.put("name", "API Test");
        jsonObject.put("latitude",50.50 );
        jsonObject.put("longitude",-155.65 );
        jsonObject.put("altitude",200 );

        return jsonObject;
    }
    public static JSONObject updateWeatherStationObject() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("external_id", "Test101");
        jsonObject.put("name", "Updated Station");
        jsonObject.put("latitude", -26.2041);
        jsonObject.put("longitude", 28.0473);
        jsonObject.put("altitude", 1550);
        return jsonObject;
    }





}
