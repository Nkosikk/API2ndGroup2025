package Tests.Weather;

import PayloadBuilder.OpenWeatherPayloadBuilder;
import RequestBuilder.OpenWeatherRequestBuilder;
import org.json.simple.JSONObject;
import org.junit.Test;

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
//                .body("message",org.hamcrest.Matchers.notNullValue());

    }
}
