package RequestBuilder;

import io.restassured.response.Response;

import static PayloadBuilder.ReqResPayloadBuilder.*;
import static Common.BasePaths.reqRes_baseUrl;
import static io.restassured.RestAssured.given;

public class ReqResRequestBuilder {

    public static String employeeNumber;

    public static Response createEmployeeRequest() {

        Response response = given().contentType("application/json")
                .when()
                .header("x-api-key","reqres-free-v1")
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
                .header("x-api-key","reqres-free-v1")
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
                .header("x-api-key","reqres-free-v1")
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
                .header("x-api-key","reqres-free-v1")
                .log().all()
                .delete(reqRes_baseUrl+"/api/users/"+employeeNumber)
                .then()
                .extract().response();

        return response;
    }



}
