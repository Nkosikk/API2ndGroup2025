package RequestBuilder;

import io.restassured.response.Response;

import static Common.Weather_BaseURL.WeatherURL;
import static PayloadBuilder.WeatherStationPayload.*;
import static PayloadBuilder.WeatherStationPayload.editWeatherStation;
import static io.restassured.RestAssured.given;

public class WeatherStationRequest {

    private static final String API_Key = "bc35408a5a9460f72d8af2c28fde22d1";

    public static String stationId;

    public static Response createWeatherStationRequest() {
        Response response = given().
                contentType("application/json").
                when().
                queryParam("appid",API_Key).
                body(createWeatherStation()).
                log().all().
                post(WeatherURL + "/data/3.0/stations").
                then().
                extract().
                response();

        stationId = response.jsonPath().getString("ID");
        // Implement the logic to create a weather station request
        return response;
    }

    public static Response getWeatherStationRequest() {
        Response response = given().
                contentType("application/json").
                when().
                queryParam("appid", API_Key).
                body(getWeatherStations()).
                log().all().
                get(WeatherURL + "/data/3.0/stations").
                then().
                extract().
                response();
        // Implement the logic to get a weather station request
        return response;
    }

    public static Response getWeatherStationRequestbyID() {
        Response response = given().
                contentType("application/json").
                when().
                queryParam("appid", API_Key).
                log().all().
                get(WeatherURL + "/data/3.0/stations/" + stationId).
                then().
                extract().
                response();
        // Implement the logic to get a weather station request
        return response;
    }

    public static Response updateWeatherStationRequest() {
        Response response = given().
                contentType("application/json").
                when().
                queryParam("appid", API_Key).
                body(updateWeatherStation()).
                log().all().
                put(WeatherURL + "/data/3.0/stations/" + stationId).
                then().
                extract().
                response();
        // Implement the logic to update a weather station request
        return response;
    }

    public static Response editWeatherStationRequest() {
        Response response = given().
                contentType("application/json").
                when().
                queryParam("appid", API_Key).
                body(editWeatherStation()).
                log().all().
                put(WeatherURL + "/data/3.0/stations/" + stationId).
                then().
                extract().
                response();
        // Implement the logic to edit a weather station request
        return response;
    }

    public static Response deleteWeatherStationRequest() {
        Response response = given().
                contentType("application/json").
                when().
                queryParam("appid", API_Key).
                log().all().
                delete(WeatherURL + "/data/3.0/stations/" + stationId).
                then().
                extract().
                response();
        // Implement the logic to delete a weather station request
        return response;
    }
}
