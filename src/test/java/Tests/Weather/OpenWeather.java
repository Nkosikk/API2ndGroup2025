package Tests.Weather;

import RequestBuilder.OpenWeatherRequestBuilder;
import io.qameta.allure.Description;
import org.testng.annotations.Test;


@Test
public class OpenWeather {

    @Description("As a user, I want to create a new weather station")
    public void createStationTest() {
        OpenWeatherRequestBuilder.createNewWeatherStationResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(401);
    }
    @Description("As a user, I want to create a empty weather station")
    @Test(dependsOnMethods = "createStationTest()")
    public void createEmptyStationNameTest() {
        OpenWeatherRequestBuilder.createEmptyStationNameResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(401);
    }

    @Description("As a user, I want to create a new weather station with measurements")
    @Test(dependsOnMethods = "createEmptyStationNameTest()")
    public void createPostMeasurementsTest() {
        OpenWeatherRequestBuilder.createPostMeasurementsResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(401);
    }

}
