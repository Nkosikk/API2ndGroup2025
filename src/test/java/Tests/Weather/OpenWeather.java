package Tests.Weather;

import PayloadBuilder.OpenWeatherPayloadBuilder;
import RequestBuilder.OpenWeatherRequestBuilder;
import jdk.jfr.Description;
import org.testng.annotations.Test;

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
                .statusLine("HTTP/1.1 201 Created")
                .body("name", org.hamcrest.Matchers.equalToIgnoringCase(OpenWeatherPayloadBuilder.weatherStation));

    }

    @Description("As an api user, I want to update weather station")
    @Test(dependsOnMethods = "testWeatherStation()")
    public void UpdateWeatherStationTests() {
        OpenWeatherRequestBuilder.UpdateWeatherStationResponse()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .body("name", org.hamcrest.Matchers.equalToIgnoringCase(OpenWeatherPayloadBuilder.UpdateStation));
    }

    @Description("As an api user, I want to Get a weather station")
    @Test(dependsOnMethods = "UpdateWeatherStationTests()")
    public void GetWeatherStationTests() {
        OpenWeatherRequestBuilder.GetWeatherStationResponse()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK");
    }

    @Description("As an api user, I want to delete a weather station")
    @Test(dependsOnMethods = "GetWeatherStationTests()")
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
