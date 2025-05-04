package RequestBuilder;

import PayloadBuilder.OpenWeatherPayloadBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static Common.Authorisations.openWeather_key;
import static Common.BasePaths.openWeather_baseUrl;
import static Common.BasePaths.reqRes_baseUrl;
import static PayloadBuilder.OpenWeatherPayloadBuilder.createNewWeatherStationObject;
import static PayloadBuilder.ReqResPayloadBuilder.createEmployeeResponse;
import static io.restassured.RestAssured.given;

public class OpenWeatherRequestBuilder {
    public static String stationID;

    public static Response createNewWeatherStationResponse() {

        Response response = given().contentType("application/json")
                .when()
                .queryParams("appid", openWeather_key)
                .body(createNewWeatherStationObject())
                .log()
                .all()
                .post(openWeather_baseUrl + "/data/3.0/stations")
                .then()
                .extract().response();

        stationID = response.jsonPath().getString("ID");

        return response;

    }
    public static Response UpdateWeatherStationResponse() {

        Response response = given().contentType("application/json")
                .when()
                .queryParams("appid", openWeather_key)
                .body(OpenWeatherPayloadBuilder.updateWeatherStationObject())
                .log()
                .all()
                .put(openWeather_baseUrl + "/data/3.0/stations/" + stationID)
                .then()
                .extract().response();

        return response;

    }
    public static Response GetWeatherStationResponse() {

        Response response = given().contentType("application/json")
                .when()
                .queryParams("appid", openWeather_key)
                .log()
                .all()
                .get(openWeather_baseUrl + "/data/3.0/stations/" + stationID)
                .then()
                .extract().response();

        return response;

    }

    public static Response DeleteWeatherStationResponse() {

        Response response = given().contentType("application/json")
                .when()
                .queryParams("appid", openWeather_key)
                .log()
                .all()
                .delete(openWeather_baseUrl + "/data/3.0/stations/" + stationID)
                .then()
                .extract().response();

        return response;

    }
}
