package Tests.Weather;

import RequestBuilder.WeatherStationRequest;
import jdk.jfr.Description;
import org.testng.annotations.Test;

@Test
public class WeatherStation {

    @Description("As a User, I want to send post request that will create new weather station")
    public void createWeatherStationTest(){
        WeatherStationRequest.createWeatherStationRequest().
                then().
                log().all().
                assertThat().
                statusCode(201);
    }

    @Description("As a User, I want to send get request that will retrieve weather station details")
    @Test(dependsOnMethods = "createWeatherStationTest")
    public void getWeatherStationTest(){
        WeatherStationRequest.getWeatherStationRequest().
                then().
                log().all().
                assertThat().
                statusCode(200);
    }

    @Description("As a User, I want to send get request that will retrieve weather station details by ID")
    @Test(dependsOnMethods = "getWeatherStationTest")
    public void getWeatherStationByIDTest(){
        WeatherStationRequest.getWeatherStationRequestbyID().
                then().
                log().all().
                assertThat().
                statusCode(200);
    }

    @Description("As a User, I want to send put request that will update weather station")
    @Test(dependsOnMethods = "getWeatherStationByIDTest")
    public void updateWeatherStationTest(){
        WeatherStationRequest.updateWeatherStationRequest().
                then().
                log().all().
                assertThat().
                statusCode(200);
    }

    @Description("As a User, I want to send patch request that will edit weather station details")
    @Test(dependsOnMethods = "updateWeatherStationTest")
    public void editWeatherStationTest(){
        WeatherStationRequest.editWeatherStationRequest().
                then().
                log().all().
                assertThat().
                statusCode(200);
    }

    @Description("As a User, I want to send delete request that will delete weather station")
    @Test(dependsOnMethods = "editWeatherStationTest")
    public void deleteWeatherStationTest(){
        WeatherStationRequest.deleteWeatherStationRequest().
                then().
                log().all().
                assertThat().
                statusCode(204);
    }
}
