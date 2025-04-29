package RequestBuilder;

import io.restassured.response.Response;

import static PayloadBuilder.WeatherStationPayloadBuilder.createWeatherStationPayload;
import static common.BasePaths.WeatherStation_baseUrl;
import static io.restassured.RestAssured.given;

public class WeatherStationRequestBuilder {

    public static Response createWeatherStationRequest() {

        return given().contentType("application/json")
                .when()
                .body(createWeatherStationPayload())//this is  calling the method in the builder class
                .log().all()
                .get(WeatherStation_baseUrl+"/data/3.0/stations")//the base url variable  called from Base
                .then()
                .log().all()
                .extract().response();

    }
}