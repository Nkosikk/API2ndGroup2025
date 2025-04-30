package RequestBuilder;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import PayloadBuilder.WeatherStationPayloadBuilder;
import static common.BasePaths.WeatherStation_baseUrl;
import static PayloadBuilder.WeatherStationPayloadBuilder.createWeatherStationPayload;
import static PayloadBuilder.ReqResPayloadBuilder.createEmployeeResponse;
import static io.restassured.RestAssured.given;





public class WeatherStationRequestBuilder {
    public static String stationID;

    public static Response createWeatherStationRequest() {

        Response response = given().contentType("application/json")
                .when()
               .queryParams("appid", "b1589ee5727295072e2272d60dfc6904")// Add the API key as a query parameter
                .body(createWeatherStationPayload())//this is  calling the method in the builder class
                .log().all()
                .post(WeatherStation_baseUrl+"/data/3.0/stations")//the base url variable  called from Base
                .then()
                .log().all()
                .extract().response();

        stationID = response.jsonPath().getString("ID");

        return response;

    }

    public static Response updateWeatherStationRequest() {
        Response response = given().contentType("application/json")
                .when()
                .queryParams("appid", "b1589ee5727295072e2272d60dfc6904")
                .body(WeatherStationPayloadBuilder.updateWeatherStationPayload())//this is  calling the method in the builder class
                .log().all()
                .put(WeatherStation_baseUrl+"/data/3.0/stations/" + stationID)//the base url variable  called from Base
                .then()
                .extract().response();


        return response;
    }


    public static Response getWeatherStationResponse() {

        Response response = given().contentType("application/json")
                .when()
                .queryParams("appid", "b1589ee5727295072e2272d60dfc6904")
                .log()
                .all()
                .get(WeatherStation_baseUrl+ "/data/3.0/stations/" + stationID)
                .then()
                .extract().response();

        return response;

    }

//    public static Response getStationMeasurementsResponse() {
//
//        Response response = given().contentType("application/json")
//                .when()
//                .queryParams("appid", "b1589ee5727295072e2272d60dfc6904")
//                .log()
//                .all()
//                .get(WeatherStation_baseUrl+ "/data/3.0/measurements?station_id=...&type=...&limit=..." + stationID)
//                .then()
//                .extract().response();
//
//        return response;

   // }

    public static Response deleteWeatherStationRequest() {

        Response response = given().contentType("application/json")
                .when()
                .queryParams("appid", "b1589ee5727295072e2272d60dfc6904")
                .log().all()
                .delete(WeatherStation_baseUrl+"/data/3.0/stations/" + stationID)//the base url variable  called from Base
                .then()
                .log().all()
                .extract().response();

        return response;
    }
}