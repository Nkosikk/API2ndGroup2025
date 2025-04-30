package RequestBuilder;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static common.BasePaths.openWeather_baseUrl;
import static PayloadBuilder.ReqResPayloadBuilder.createEmployeeResponse;
import static io.restassured.RestAssured.given;

public class OpenWeatherRequestBuilder {
    public static String external_id;

    public static Response createNewWeatherStationResponse() {

        Response response = given().contentType("application/json")
                .when()
                .queryParams("appid", "1589ee5727295072e2272d60dfc6904")
                .body(createNewWeatherStationResponse())
                .log()
                .all()
                .post(openWeather_baseUrl + "/data/3.0/stations")
                .then()
                .extract().response();

        external_id = response.jsonPath().getString("id");

        return response;

    }
}
