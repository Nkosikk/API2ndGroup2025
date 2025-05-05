package Tests.Countries;

import PayloadBuilder.RestCountSchemaPayloadBuilder;
import RequestBuilder.CountryRequestBuilder;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
@Test
public class CountryAPI_Tese {

    @Description("Test to validate the schema of the response from the API")
    public void testSchemaValidation() {
        try {
            // Validate the response schema
            CountryRequestBuilder.getAllCountries()
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .body(JsonSchemaValidator.matchesJsonSchema(RestCountSchemaPayloadBuilder.getSchemaPayload()));

            System.out.println("Schema validation passed successfully.");
        } catch (Exception e) {
            // Print failure message
            System.out.println("Schema validation failed: " + e.getMessage());
            throw e; // Re-throw the exception to mark the test as failed
        }
    }

@Description("Test to validate the country count")
    // This test is used to validate the number of countries returned by the API
    // The expected number of countries is 195
    // The actual number of countries is retrieved from the API response
    // The test will fail if the actual number does not match the expected number

public void testCountryCounts() {
    int expectedCountryCount = 195;
    int actualCountryCount = CountryRequestBuilder.getAllCountries()
            .then()
//            .log().all()
            .extract()
            .jsonPath()
            .getList("$")
            .size();

        System.out.println("Expected count: " + expectedCountryCount);
        System.out.println("Actual count: " + actualCountryCount);

        Assert.assertEquals(actualCountryCount, expectedCountryCount, "Expected country count does not match actual count.");
    }

    @Description("Test to check if South African Sign Language is present in the list of languages")
    public void testSouthAfricanSignLanguage(){
            Response response = CountryRequestBuilder.getAllCountries()
                    .then()
//                    .log().all()
                    .extract()
                    .response();

            // Extract the list of countries
            List<Map<String, Object>> countries = response.jsonPath().getList("$");

            // Check if any country contains "South African Sign Language" in its languages
            boolean isLanguageFound = countries.stream()
                    .anyMatch(country -> {
                        Map<String, String> languages = (Map<String, String>) country.get("languages");
                        return languages != null && languages.containsValue("South African Sign Language");
                    });

        // Print a message indicating whether the language is found
        if (isLanguageFound) {
            System.out.println("South African Sign Language is present in the list of languages.");
        } else {
            System.out.println("South African Sign Language is NOT present in the list of languages.");
        }

            assertEquals(isLanguageFound, true, "South African Sign Language not found in the list of languages.");
        }

    @Description("Test to check if Afrikaans Language is present in the list of languages")
    public void testAfrikaansLanguage(){
            Response response = CountryRequestBuilder.getAllCountries()
                    .then()
//                    .log().all()
                    .extract()
                    .response();

            // Extract the list of countries
            List<Map<String, Object>> countries = response.jsonPath().getList("$");

            // Check if any country contains "South African Sign Language" in its languages
            boolean isLanguageFound = countries.stream()
                    .anyMatch(country -> {
                        Map<String, String> languages = (Map<String, String>) country.get("languages");
                        return languages != null && languages.containsValue("Afrikaans");
                    });

        // Print a message indicating whether the language is found
        if (isLanguageFound) {
            System.out.println("Afrikaans Language is present in the list of languages.");
        } else {
            System.out.println("Afrikaans Language is NOT present in the list of languages.");
        }

            assertEquals(isLanguageFound, true, "Afrikaans Language not found in the list of languages.");
        }
}
