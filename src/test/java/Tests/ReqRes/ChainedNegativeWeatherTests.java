package Tests.ReqRes;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ChainedNegativeWeatherTests {

    private static final String API_KEY = System.getenv("OPENWEATHERMAP_API_KEY");
    private static final String BASE_URL = "https://api.openweathermap.org/data/3.0";
    private static final String NON_EXISTENT_STATION_ID = "987654321";

    @Test
    public void testUpdateNonExistingStation() {
        String updatedPayload = "{\"name\":\"AttemptedUpdate\"}";

        given()
                .queryParam("appid", API_KEY)
                .contentType("application/json")
                .body(updatedPayload)
                .when()
                .put(BASE_URL + "/stations/" + NON_EXISTENT_STATION_ID)
                .then()
                .statusCode(404)
                .body("message", containsString("Not Found"));
    }

    @Test(dependsOnMethods = "testUpdateNonExistingStation")
    public void testGetNonExistentStationAfterFailedUpdate() {
        given()
                .queryParam("appid", API_KEY)
                .when()
                .get(BASE_URL + "/stations/" + NON_EXISTENT_STATION_ID)
                .then()
                .statusCode(404)
                .body("message", containsString("Not Found"));
    }
}

