package Tests.Weather;

import PayloadBuilder.OpenWeatherPayloadBuilder;
import RequestBuilder.OpenWeatherRequestBuilder;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class OpenWeather {
    @Test
    public void testWeatherStation() {
        // Create a new weather station
        OpenWeatherRequestBuilder.createNewWeatherStationResponse()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(201)
                .statusLine("HTTP/1.1 201 Created");
                //.body("message", notNullValue());
    }

    @Test(dependsOnMethods = "testWeatherStation")
    public void UpdateWeatherStationTests() {
        OpenWeatherRequestBuilder.UpdateWeatherStationResponse()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK");
    }

    @Test(dependsOnMethods = "GetWeatherStationTests")
    public void GetWeatherStationTests() {
        OpenWeatherRequestBuilder.GetWeatherStationResponse()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK");
    }

    @Test(dependsOnMethods = "GetWeatherStationTests")
    public void DeleteWeatherStationTests() {
        OpenWeatherRequestBuilder.DeleteWeatherStationResponse()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(204)
                .statusLine("HTTP/1.1 204 No Content");
    }
}