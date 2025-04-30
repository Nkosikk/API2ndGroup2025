package PayloadBuilder;

import Common.TestDataGenerator;
import com.github.javafaker.Faker;
import org.json.simple.JSONObject;

public class OpenWeatherPayloadBuilder {

    public static String weatherStation = TestDataGenerator.Station;
    public static String externalID = TestDataGenerator.External_ID;
    public static String UpdateStation = Faker.instance().country().capital();

    public static JSONObject createNewWeatherStationObject() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("external_id", externalID);
        jsonObject.put("name", weatherStation);
        jsonObject.put("latitude",50.50 );
        jsonObject.put("longitude",-155.65 );
        jsonObject.put("altitude",200 );

        return jsonObject;
    }
    public static JSONObject updateWeatherStationObject() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("external_id", externalID);
        jsonObject.put("name", UpdateStation);
        jsonObject.put("latitude", -26.2041);
        jsonObject.put("longitude", 28.0473);
        jsonObject.put("altitude", 1550);
        return jsonObject;
    }





}
