package RequestBuilder;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static Common.BasePaths.BaseURL;
import static Common.BasePaths.all_countries;


public class CountryRequestBuilder {

    public static Response getAllCountries() {
        return RestAssured
                .given()
                .baseUri(BaseURL)
                .basePath(all_countries)
                .when()
                .log().all()
                .get()
                .then()
                .extract()
                .response();
    }
}
