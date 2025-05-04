package PayloadBuilder;

import com.github.javafaker.Faker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import static Common.TestDataGenerator.*;

public class OpenWeatherPayloadBuilder {

    public static JSONObject createNewWeatherStationObject() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("external_id", external_id);
        jsonObject.put("latitude", latitude);
        jsonObject.put("longitude", longitude );
        jsonObject.put("altitude",altitude );

        return jsonObject;
    }
    public static JSONObject createEmptyStationNameObject() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "");
        jsonObject.put("external_id", external_id);
        jsonObject.put("latitude", latitude);
        jsonObject.put("longitude", longitude );
        jsonObject.put("altitude",altitude );

        return jsonObject;
    }
    public static JSONObject createPostMeasurementsObject() {
        // Generate random data for the payload

        String station_id = Faker.instance().regexify("[a-f0-9]{24}");
        String dt = String.valueOf(Faker.instance().number().numberBetween(1600000000, 1700000000)); // Random timestamp
        String temperature = String.valueOf(Faker.instance().number().randomDouble(1, -30, 50)); // Random timestamp
        String wind_speed = String.valueOf(Faker.instance().number().randomDouble(1, 0, 20)); // Random timestamp
        String wind_gust = String.valueOf(Faker.instance().number().randomDouble(1, 0, 30)); // Random timestamp
        String pressure = String.valueOf(Faker.instance().number().numberBetween(900, 1100)); // Random timestamp
        String humidity = String.valueOf(Faker.instance().number().numberBetween(0, 100)); // Random timestamp
        String rain_1h = String.valueOf(Faker.instance().number().numberBetween(0, 100)); // Random timestamp

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("station_id", station_id );
        jsonObject.put("dt", dt); // Random timestamp
        jsonObject.put("temperature", temperature); // Random temperature
        jsonObject.put("wind_speed", wind_speed); // Random wind speed
        jsonObject.put("wind_gust", wind_gust); // Random wind gust
        jsonObject.put("pressure", pressure); // Random pressure
        jsonObject.put("humidity", humidity); // Random humidity
        jsonObject.put("rain_1h", rain_1h); // Random rain in 1 hour

        // Adding the "clouds" array

        JSONArray cloudsArray = new JSONArray();
        JSONObject cloudCondition = new JSONObject();

        String condition = Faker.instance().weather().description();// Random cloudiness

        cloudCondition.put("condition", condition );
        cloudsArray.add(cloudCondition);
        jsonObject.put("clouds", cloudsArray);// Random rain in 1 hour

        return jsonObject;
    }

}
