package RequestBuilder;

import io.restassured.response.Response;

import static PayloadBuilder.ReqResPayloadBuilder.*;
import static Common.BasePaths.reqRes_baseUrl;
import static io.restassured.RestAssured.given;

public class ReqResRequestBuilder {

    public static String employeeNumber;
    public static Response createEmployeeRequest(){

        Response response = given().contentType("application/json")
                .when()
                .body(createEmployeeObject())
                .log().all()
                .post(reqRes_baseUrl+"/api/users")
                .then()
                .extract().response();

        employeeNumber = response.jsonPath().getString("id");

        return response;
    }
    public static Response updateEmployeeRequest(){

        Response response = given().contentType("application/json")
                .when()
                .body(updateEmployeObject())
                .log().all()
                .put(reqRes_baseUrl+"/api/users/"+employeeNumber)
                .then()
                .extract().response();

        return response;
    }

    public static Response PatchEmployeeRequest(){

        Response response = given().contentType("application/json")
                .when()
                .body(PatchEmployeeObject())
                .log().all()
                .patch(reqRes_baseUrl+"/api/users/"+employeeNumber)
                .then()
                .extract().response();

        return response;
    }
    public static Response deleteEmployeeRequest(){

        Response response = given().contentType("application/json")
                .when()
                .log().all()
                .delete(reqRes_baseUrl+"/api/users/"+employeeNumber)
                .then()
                .extract().response();

        return response;
    }



}
