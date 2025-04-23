package PayloadBuilder;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class WeatherStationPayload {
    @Test
    public static JSONObject createWeatherStation(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("external_id", "SA_DUR104");
        jsonObject.put("name", "Durban");
        jsonObject.put("latitude", 40.71);
        jsonObject.put("longitude", -74.60);
        jsonObject.put("altitude", 10);
        //jsonObject.put("description", "A weather station in New York City");
        return jsonObject;
    }

    public static JSONObject getWeatherStations(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("external_id", "SA_DUR104");
        jsonObject.put("name", "Durban");
        jsonObject.put("country", "South Africa");
        jsonObject.put("latitude", 40.71);
        jsonObject.put("longitude", -74.60);
        jsonObject.put("altitude", 10);
        return jsonObject;
    }

    public static JSONObject updateWeatherStation(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("external_id", "SA_DUR104");
        jsonObject.put("name", "Durban");
        jsonObject.put("country", "South Africa");
        jsonObject.put("latitude", 40.71);
        jsonObject.put("longitude", -74.60);
        jsonObject.put("altitude", 10);
        return jsonObject;
    }

    public static JSONObject editWeatherStation(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("external_id", "SA_DUR104");
        jsonObject.put("name", "KwaZulu-Natal Durban");
        jsonObject.put("country", "South Africa");
        jsonObject.put("latitude", 40.71);
        jsonObject.put("longitude", -74.60);
        jsonObject.put("altitude", 10);
        return jsonObject;
    }
}
