package Tests.Weather;

import RequestBuilder.OpenWeatherRequestBuilder;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;



public class test {
    @Test(priority = 1)
    public void testCreateWeatherStation() {
        Response response = OpenWeatherRequestBuilder.createNewWeatherStationResponse();

        // Print response for visibility
        response.prettyPrint();

        // Validate the response
        Assert.assertEquals(response.statusCode(), 201, "Weather station creation Passsed.");
    }

    @Test(priority = 2)
    public void testGetWeatherStation() {
        Response response = OpenWeatherRequestBuilder.getWeatherStationResponse();

        // Print response for visibility
        response.prettyPrint();

        // Validate the response
        Assert.assertEquals(response.statusCode(), 200, "Fetching weather station Passsed.");
        Assert.assertEquals(response.jsonPath().getString("id"), OpenWeatherRequestBuilder.external_id, "Station ID mismatch.");

    }
    @Test(priority = 3)
    public void testUpdateWeatherStation() {
        Response response = OpenWeatherRequestBuilder.updateWeatherStationResponse();

        // Print response for visibility
        response.prettyPrint();

        // Validate the response
        Assert.assertEquals(response.statusCode(), 200, "Weather station update Passsed.");
    }




}


