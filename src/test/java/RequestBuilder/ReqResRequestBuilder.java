package RequestBuilder;

import io.restassured.response.Response;

import static PayloadBuilder.ReqResPayloadBuilder.*;
import static Common.BasePaths.reqRes_baseURI;
import static io.restassured.RestAssured.given;

public class ReqResRequestBuilder {

    public static String employeeNumber;
    public static Response createEmployeeRequest(){

        Response response = given().contentType("application/json")
                .when()
                .body(createEmployeeResponse())
                .log().all()
                .post(reqRes_baseURI +"/api/users")
                .then()
                .extract().response();

        employeeNumber = response.jsonPath().getString("id");

        return response;
    }
    public static Response updateEmployeeRequest(){

        Response response = given().contentType("application/json")
                .when()
                .body(updateEmployeeResponse())
                .log().all()
                .put(reqRes_baseURI +"/api/users/"+employeeNumber)
                .then()
                .extract().response();

        return response;
    }

    public static Response PatchEmployeeRequest(){

        Response response = given().contentType("application/json")
                .when()
                .body(PatchEmployeeResponse())
                .log().all()
                .patch(reqRes_baseURI +"/api/users/"+employeeNumber)
                .then()
                .extract().response();

        return response;
    }
    public static Response deleteEmployeeRequest(){

        Response response = given().contentType("application/json")
                .when()
                .log().all()
                .delete(reqRes_baseURI +"/api/users/"+employeeNumber)
                .then()
                .extract().response();

        return response;
    }



}
