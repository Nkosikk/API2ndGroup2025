package Tests.Weather;

import RequestBuilder.WeatherRequestBuilder; // Import the WeatherRequestBuilder class
import jdk.jfr.Description;
import org.testng.annotations.Test;
@Test
public class test {

    @Description("As an api user, I want to send post  request that will creat weather station")
    @Test
    public void creatStationTest() {
        WeatherRequestBuilder.createWeatherRequest()
                .then() // Call .then() on the Response object
                .log().all()
                .assertThat()
                .statusCode(201); // Updated to 200 for a successful GET request
    }
@Description("As an api user, I want to send get request that will get weather station")
    @Test(dependsOnMethods = "creatStationTest")
    public void getStationTest() {
        WeatherRequestBuilder.createWeatherRequest()
                .then() // Call .then() on the Response object
                .log().all()
                .assertThat()
                .statusCode(200); // Updated to 200 for a successful GET request
    }
}


