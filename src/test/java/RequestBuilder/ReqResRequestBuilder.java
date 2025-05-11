package RequestBuilder;

import io.qameta.allure.internal.shadowed.jackson.core.TreeNode;
import io.restassured.response.Response;

import java.util.Random;

import static PayloadBuilder.ReqResPayloadBuilder.*;
import static common.BasePaths.reqRes_baseUrl;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.sessionId;

public class ReqResRequestBuilder {
    public static String employeeNumber;

    public static Response createEmployeeRequest() {

        Response response = given().contentType("application/json")
                .when()
                .header("x-api-key", "reqres-free-v1")
                .body(createEmployeeResponse())
                .log().all()
                .post(reqRes_baseUrl + "/api/users")
                .then()
                .extract().response();

        employeeNumber = response.jsonPath().getString("id");

        return response;
    }

    public static Response updateEmployeeRequest() {

        Response response = given().contentType("application/json")
                .when()
                .header("x-api-key", "reqres-free-v1")
                .body(updateEmployeeResponse())
                .log().all()
                .put(reqRes_baseUrl + "/api/users/" + employeeNumber)
                .then()
                .extract().response();

        return response;
    }

    public static Response patchEmployeeRequest() {

        Response response = given().contentType("application/json")
                .when()
                .header("x-api-key", "reqres-free-v1")
                .body(PatchEmployeeResponse())
                .log().all()
                .patch(reqRes_baseUrl + "/api/users/" + employeeNumber)
                .then()
                .extract().response();

        return response;
    }

    public static Response getEmployeeRequest() {
        String Id = "2";
        return given()
                .contentType("application/json")
                .when()
                .header("x-api-key", "reqres-free-v1")
                .log().all()
                .get(reqRes_baseUrl + "/api/users/" + Id)
                .then()
                .extract().response();
    }

    public static Response deleteEmployeeRequest() {

        Response response = given().contentType("application/json")
                .when()
                .header("x-api-key", "reqres-free-v1")
                .log().all()
                .delete(reqRes_baseUrl + "/api/users/" + employeeNumber)
                .then()
                .extract().response();

        return response;
    }


}
