package RequestBuilder;

import PayloadBuilder.OpenWeatherPayloadBuilder;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static Common.BasePaths.openWeather_baseUrl;
import static Common.BasePaths.reqRes_baseUrl;
import static PayloadBuilder.OpenWeatherPayloadBuilder.createNewWeatherStationObject;
import static PayloadBuilder.ReqResPayloadBuilder.createEmployeeResponse;
import static io.restassured.RestAssured.given;

public class OpenWeatherRequestBuilder {
    public static String external_id;
    public static String station_id;

    public static Response createNewWeatherStationResponse() {

        // Build the payload
        JSONObject payload = createNewWeatherStationObject();

        // Send the request
        Response response = given()
                .contentType("application/json")
                .queryParam("appid", "b037d883ff1da2c5f7376e20ba82247b")
                .body(payload.toJSONString())
                .log().all()
                .post(openWeather_baseUrl + "/data/3.0/stations")
                .then()
                .extract().response();

        external_id = response.jsonPath().getString("ID");

        return response;

    }

    public static Response getWeatherStationResponse() {

        Response response = given().contentType("application/json")
                .when()
                .queryParams("appid", "b037d883ff1da2c5f7376e20ba82247b")
                .log()
                .all()
                .get(openWeather_baseUrl + "/data/3.0/stations/" + external_id)
                .then()
                .extract().response();

        return response;

    }

    public static Response  updateWeatherStationResponse() {
        Response response = given()
                .contentType("application/json")
                .queryParam("appid", "b037d883ff1da2c5f7376e20ba82247b")
                .body(OpenWeatherPayloadBuilder.updateWeatherStationObject().toJSONString())
                .log().all()
                .put(openWeather_baseUrl + "/data/3.0/stations/" + station_id)
                .then()
                .extract()
                .response();

        return response;
    }


}
