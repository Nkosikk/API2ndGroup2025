package Tests.Weather;

import RequestBuilder.ReqResRequestBuilder;
import RequestBuilder.WeatherStationRequestBuilder;
import jdk.jfr.Description;
import org.testng.annotations.Test;


//the @Test is placed at class level not individual method level so that everything is executed
@Test
public class WeatherStation {

    @Description("As an API user, I want to send a request to create a new weather station and verify the response")

    public void createWeatherStationTest(){
        WeatherStationRequestBuilder.createWeatherStationRequest()// we need to do assertions/validations
                .then()//keyword for validation
                .log().all()
                .assertThat()
                .statusCode(201);
    }

    @Description("As an api user, I want to send put request that will update station name")
    @Test(dependsOnMethods = "createWeatherStationTest()")
    public void updateWeatherStationTest(){
        WeatherStationRequestBuilder.updateWeatherStationRequest()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);
    }

    @Description("As an api user, I want to send patch request that will update employee")
    @Test(dependsOnMethods = "updateWeatherStationTest()")
    public void checkWeatherStationTest(){
        WeatherStationRequestBuilder.getWeatherStationResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);
    }
    @Description("As an api user, I want to send delete request that will delete employee")
    @Test(dependsOnMethods = "getWeatherStationTest()")
    public void deleteWeatherStationTest(){
        WeatherStationRequestBuilder.deleteWeatherStationRequest()
                .then()
                .log().all()
                .assertThat()
                .statusCode(204);
    }
}
