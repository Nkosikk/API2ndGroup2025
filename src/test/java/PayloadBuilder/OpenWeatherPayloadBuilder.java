package PayloadBuilder;

import Common.TestDataGenerator;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class OpenWeatherPayloadBuilder {

    static Double longitudeNo = Double.valueOf(TestDataGenerator.longitude);
    static Double latitudeNo = Double.valueOf(TestDataGenerator.latitude);
    static int altitudeNo = Integer.valueOf(TestDataGenerator.altitude);
    public static JSONObject createNewWeatherStationObject() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("external_id", "Test101");
        jsonObject.put("name", "API Test");
        jsonObject.put("latitude",latitudeNo );
        jsonObject.put("longitude",longitudeNo );
        jsonObject.put("altitude",altitudeNo );

        return jsonObject;
    }
    public static JSONObject updateWeatherStationObject() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("external_id", "Test101");
        jsonObject.put("name", "Updated Station");
        jsonObject.put("latitude", latitudeNo);
        jsonObject.put("longitude", longitudeNo);
        jsonObject.put("altitude", altitudeNo);
        return jsonObject;
    }





}
