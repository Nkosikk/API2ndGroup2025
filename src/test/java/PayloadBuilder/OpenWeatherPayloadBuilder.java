package PayloadBuilder;

import com.github.javafaker.Faker;
import org.json.simple.JSONObject;

public class OpenWeatherPayloadBuilder {

    public static JSONObject createNewWeatherStationResponse() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "API Test");
        jsonObject.put("external_id", "Test101");
        jsonObject.put("latitude",50.50 );
        jsonObject.put("longitude",-155.65 );
        jsonObject.put("altitude",200 );

        return jsonObject;
    }
    
    public static JSONObject updateWeatherStationObject() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "API Test");
        jsonObject.put("external_id", "Test101");
        jsonObject.put("latitude",50.50 );
        jsonObject.put("longitude",-155.65 );
        jsonObject.put("altitude",200 );
        jsonObject.put("country", "USA");

        return jsonObject;
    }
    
    public static JSONObject PatchWeatherStationObject() {

        String updateCountry = Faker.instance().address().country();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "API Test");
        jsonObject.put("external_id", "Test101");
        jsonObject.put("latitude",50.50 );
        jsonObject.put("longitude",-155.65 );
        jsonObject.put("altitude",200 );
        jsonObject.put("country", updateCountry);

        return jsonObject;
    }

}
