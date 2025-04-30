package RequestBuilder;

import io.restassured.response.Response;

import static PayloadBuilder.WeatherStationPayloadBuilder.createWeatherStationPayload;
import static common.BasePaths.WeatherStation_baseUrl;
import static io.restassured.RestAssured.given;

public class WeatherStationRequestBuilder {

    public static Response createWeatherStationRequest() {

        return given().contentType("application/json")
                .when()
               .queryParams("appid", "b1589ee5727295072e2272d60dfc6904")// Add the API key as a query parameter
                .body(createWeatherStationPayload())//this is  calling the method in the builder class
                .log().all()
                .post(WeatherStation_baseUrl+"/data/3.0/stations")//the base url variable  called from Base
                .then()
                .log().all()
                .extract().response();

    }

    public static Response updateWeatherStationRequest() {

        return given().contentType("application/json")
                .when()
                .queryParams("appid", "b1589ee5727295072e2272d60dfc6904")
                .body(createWeatherStationPayload())//this is  calling the method in the builder class
                .log().all()
                .post(WeatherStation_baseUrl+"/data/3.0/stations")//the base url variable  called from Base
                .then()
                .log().all()
                .extract().response();

    }

    public static Response patchWeatherStationRequest() {

        return given().contentType("application/json")
                .when()
                .queryParams("appid", "b1589ee5727295072e2272d60dfc6904")
                .body(createWeatherStationPayload())//this is  calling the method in the builder class
                .log().all()
                .post(WeatherStation_baseUrl+"/data/3.0/stations")//the base url variable  called from Base
                .then()
                .log().all()
                .extract().response();

    }

    public static Response deleteWeatherStationRequest() {

        return given().contentType("application/json")
                .when()
                .queryParams("appid", "b1589ee5727295072e2272d60dfc6904")
                .body(createWeatherStationPayload())//this is  calling the method in the builder class
                .log().all()
                .post(WeatherStation_baseUrl+"/data/3.0/stations")//the base url variable  called from Base
                .then()
                .log().all()
                .extract().response();

    }
}