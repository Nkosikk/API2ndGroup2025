package RequestBuilder;

import jdk.jfr.Description;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



public class WeatherNegativeTests {

    private static final String INVALID_API_KEY = "invalid_api_key";
    private static final String BASE_URL = "https://api.openweathermap.org/data/3.0";
    private static final String EXISTING_STATION_ID = "some_existing_station_id"; // Replace with a known ID

    @Test
    @Description("As an API user, I want to send a request to create a new weather station and verify the response")
    public void testGetStationWithInvalidApiKey() {
        given()
                .queryParam("appid", INVALID_API_KEY)
                .when()
                .get(BASE_URL + "/stations/" + EXISTING_STATION_ID)
                .then()
                .statusCode(401)
                .body("message", containsString("Invalid API key")); // You might assert on the error message as well
    }

    @Test
    public void testRegisterStationWithMissingName() {
        String invalidPayload = "{\"latitude\":37.77,\"longitude\":-122.43}";

        given()
                .queryParam("appid", System.getenv("OPENWEATHERMAP_API_KEY")) // Assuming you have a valid key for this test
                .contentType("application/json")
                .body(invalidPayload)
                .when()
                .post(BASE_URL + "/stations")
                .then()
                .statusCode(400)
                .body("message", containsString("Invalid value for parameter")); // Or a similar error message
    }

    @Test
    public void testGetNonExistingStation() {
        String nonExistingId = "999999";

        given()
                .queryParam("appid", System.getenv("OPENWEATHERMAP_API_KEY"))
                .when()
                .get(BASE_URL + "/stations/" + nonExistingId)
                .then()
                .statusCode(404)
                .body("message", containsString("Not Found"));
    }
}
