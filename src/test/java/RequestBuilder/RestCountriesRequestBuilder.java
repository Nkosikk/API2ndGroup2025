package RequestBuilder;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static Common.BasePaths.restCountries_baseUrl;
import static PayloadBuilder.RestCountriesPayloadBuilder.getAllCountries;
import static io.restassured.RestAssured.given;

public class RestCountriesRequestBuilder  {
    public static String schema;

    public static Response verifySchema() {

        Response response = RestAssured.given()
                .contentType("application/json")
                .when()
                .body(getAllCountries())
                .log()
                .all()
                .get(restCountries_baseUrl + "/v3.1/all")
                .then()
                .extract().response();

        schema = response.jsonPath().getString("id");

        return response;

    }
}
