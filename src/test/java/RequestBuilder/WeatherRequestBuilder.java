package RequestBuilder;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class WeatherRequestBuilder {
    public static String cityName;

    public static Response createWeatherRequest() {
        Response response = given().contentType("application/json")
                .when()
                .log().all()
                .get("https://api.openweathermap.org/data/2.5/weather?q=London&appid=YOUR_API_KEY")
                .then()
                .extract().response();

        cityName = response.jsonPath().getString("San Francisco Test Station");

        return response;
    }

    public static <T, R> void creatWeatherRequest() {
    }
}
