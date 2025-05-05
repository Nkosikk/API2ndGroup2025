package RequestBuilder;

import io.restassured.response.Response;
import org.testng.Assert;

import java.util.List;

import static Common.BasePaths.openWeather_baseUrl;
import static Common.BasePaths.restCountries_baseUrl;
import static RequestBuilder.OpenWeatherRequestBuilder.stationID;
import static io.restassured.RestAssured.given;

public class RestCountriesRequestBuilder {
    public static Response GetRestCountriesResponse() {

        Response response = given().contentType("application/json")
                .when()
                .log()
                .all()
                .get(restCountries_baseUrl + "/all")
                .then()
                .extract().response();

        return response;
    }

    public static Response VerifyTotalNumberOfCountriesResponse() {

        Response response = given().contentType("application/json")
                .when()
                .log()
                .all()
                .get(restCountries_baseUrl + "/all")
                .then()
                .extract().response();
        List<Object> countries = response.jsonPath().getList("$");
        Assert.assertEquals(195, countries.size(), "The total number of countries is not 195.");

        return response;
    }

    public static Response VerifySignLanguageIsOfficialLanguageResponse() {
        boolean isSignLanguageOfficialInSouthAfrica = false;
        Response response = given().contentType("application/json")
                .when()
                .log()
                .all()
                .get(restCountries_baseUrl + "/all")
                .then()
                .extract().response();
        List<Object> countries = response.jsonPath().getList("$");
        for (Object country : countries) {
            List<String> languages = response.jsonPath().getList("languages");
            if (languages.contains("Sign Language")) {
                Assert.assertTrue(languages.contains("Sign Language"), "Sign Language is not an official language.");
            }
        }
        Assert.assertTrue(isSignLanguageOfficialInSouthAfrica, "Sign Language is not an official language in South Africa.");
        return response;
    }


}
