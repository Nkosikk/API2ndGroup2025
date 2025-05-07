package RequestBuilder;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import java.io.File;

import static Common.Authorisations.reqRes_key;

import static PayloadBuilder.ReqResPayloadBuilder.*;


import static common.BasePaths.reqRes_baseUrl;
import static io.restassured.RestAssured.given;

public class ReqResRequestBuilder {

    public static String employeeNumber;

    public static Response createEmployeeRequest() {

        Response response = given().contentType("application/json")
                .when()
                .header("x-api-key",reqRes_key)
                .body(createEmployeeResponse())
                .log().all()
                .post(reqRes_baseUrl + "/api/users")
                .then()
                .extract().response();

        employeeNumber = response.jsonPath().getString("id");

        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/schemas/createEmployee.json")));

        return response;
    }

    public static Response updateEmployeeRequest() {

        Response response = given().contentType("application/json")
                .when()
                .header("x-api-key",reqRes_key)
                .body(updateEmployeeResponse())
                .log().all()
                .put(reqRes_baseUrl + "/api/users/" + employeeNumber)
                .then()
                .extract().response();

        return response;
    }

    public static Response PatchEmployeeRequest(){

        Response response = given().contentType("application/json")
                .when()
                .header("x-api-key",reqRes_key)
                .body(PatchEmployeeResponse())
                .log().all()
                .patch(reqRes_baseUrl+"/api/users/"+employeeNumber)
                .then()
                .extract().response();

        return response;
    }
    public static Response deleteEmployeeRequest(){

        Response response = given().contentType("application/json")
                .when()
                .header("x-api-key",reqRes_key)
                .log().all()
                .delete(reqRes_baseUrl+"/api/users/"+employeeNumber)
                .then()
                .extract().response();

        return response;
    }



}
