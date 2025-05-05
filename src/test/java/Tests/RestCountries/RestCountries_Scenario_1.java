package Tests.RestCountries;

import RequestBuilder.RestCountriesRequestBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Test
public class RestCountries_Scenario_1 {

    @Description("This test case validates the schema of the response from the RestCountries API")
    // It sends a GET request to the API and checks if the response matches the expected JSON schema
    // The test uses RestAssured library for making HTTP requests and validating the response
    // The schema file is expected to be located in the classpath with the name "restcountries-schema.json"
    // The test also logs the response and checks if the status code is 200 (OK)
    // If the schema validation passes, it prints a success message in the test report
    @Test
    public void verifySchemaTest() {
        RestCountriesRequestBuilder.verifySchema()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);
    }
}
