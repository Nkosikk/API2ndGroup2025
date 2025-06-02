package PayloadBuilder;

import Common.TestDataGenerator;
import com.github.javafaker.Faker;
import org.json.simple.JSONObject;

public class OpenWeatherPayloadBuilder {

    public static String weatherStation = TestDataGenerator.Station;
    public static String externalID = TestDataGenerator.External_ID;
    public static String UpdateStation = Faker.instance().country().capital();
    public static long altitude = TestDataGenerator.altitude;
    //public static double longitude = TestDataGenerator.longitude;
   // public static double latitude = TestDataGenerator.latitude;

    public static JSONObject createNewWeatherStationObject() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("external_id", externalID);
        jsonObject.put("name", weatherStation);
        jsonObject.put("latitude", 50.20);
        jsonObject.put("longitude", -10.95);
        jsonObject.put("altitude", altitude);

        return jsonObject;
    }

    public static JSONObject updateWeatherStationObject() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("external_id", externalID);
        jsonObject.put("name", UpdateStation);
        jsonObject.put("latitude", 50.20);
        jsonObject.put("longitude", -10.95);
        jsonObject.put("altitude", altitude);
        return jsonObject;
    }

}
