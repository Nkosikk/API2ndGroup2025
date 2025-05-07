package RequestBuilder;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import java.io.File;

import static common.BasePaths.dogApi_baseUrl;
import static io.restassured.RestAssured.given;

public class DogsRequestBuilder {
    public static Response GetallBreads() {

        Response response = given().contentType("application/json")
                .when()
                .log()
                .all()
                .get(dogApi_baseUrl + "/breeds/list/all")
                .then()
                .extract().response();

        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/schemas/getAllBreeds.json")));
        return response;

    }
}