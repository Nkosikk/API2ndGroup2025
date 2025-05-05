package Common;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class QueryParamsAppid {

    public static RequestSpecification queryParams(String appid, String s){

        // This method is used to set the query parameters for the OpenWeather API requests
        // It takes two parameters: appid (API key) and s (city name)
        // It returns a RequestSpecification object with the query parameters set
    return given()
            .queryParam("appid", "1589ee5727295072e2272d60dfc6904")
            .queryParam("s", s);
    }
}
