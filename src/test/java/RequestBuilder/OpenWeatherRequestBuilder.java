package RequestBuilder;

import io.restassured.response.Response;

import static PayloadBuilder.OpenWeatherPayloadBuilder.updateWeatherStationObject;
import static common.BasePaths.openWeather_baseUrl;
import static io.restassured.RestAssured.given;

public class OpenWeatherRequestBuilder {
    public static String stationID;

    // Existing createNewWeatherStationResponse method...

    public static Response createNewWeatherStationResponse() {
        Response response = given().contentType("application/json")
                .when()
                .queryParams("appid", "1589ee5727295072e2272d60dfc6904")
                .body(updateWeatherStationObject())
                .log()
                .all()
                .post(openWeather_baseUrl + "/data/3.0/stations")
                .then()
                .extract().response();

        stationID = response.jsonPath().getString("ID");
        return response;
    }

    public static Response UpdateWeatherStationResponse() {
        return given().contentType("application/json")
                .when()
                .queryParams("appid", "1589ee5727295072e2272d60dfc6904")
                .body(updateWeatherStationObject())
                .log()
                .all()
                .put(openWeather_baseUrl + "/data/3.0/stations/" + stationID)
                .then()
                .extract().response();
    }
    public static Response GetWeatherStationResponse() {
        return given().contentType("application/json")
                .when()
                .queryParams("appid", "1589ee5727295072e2272d60dfc6904")
                .log()
                .all()
                .get(openWeather_baseUrl + "/data/3.0/stations/" + stationID)
                .then()
                .extract().response();
    }
    public static Response DeleteWeatherStationResponse() {
        return given().contentType("application/json")
                .when()
                .queryParams("appid", "1589ee5727295072e2272d60dfc6904")
                .log()
                .all()
                .delete(openWeather_baseUrl + "/data/3.0/stations/" + stationID)
                .then()
                .extract().response();
    }
}
