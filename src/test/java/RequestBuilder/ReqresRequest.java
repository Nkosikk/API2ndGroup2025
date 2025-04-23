package RequestBuilder;

import io.restassured.response.Response;

import static Common.BaseURL.ReqresURL;
import static PayloadBuilder.ReqresPayload.*;
import static io.restassured.RestAssured.given;

public class ReqresRequest {

    public static String employeeId;

    public static Response createEmployeeRequest() {
        Response response = given().
                contentType("application/json").
                when().
                body(createEmployee()).
                log().all().
                post(ReqresURL + "/api/users").
                then().
                extract().
                response();

        employeeId = response.jsonPath().getString("id");
        return response;

    }

    public static Response UpdateEmployeeRequest() {
        Response response = given().
                contentType("application/json").
                when().
                body(updateEmployee()).
                log().all().
                put(ReqresURL + "/api/users/" + employeeId).
                then().
                extract().
                response();

        return response;
    }

    public static Response EditEmployeeRequest() {
        Response response = given().
                contentType("application/json").
                when().
                body(editEmployee()).
                log().all().
                patch(ReqresURL + "/api/users/" + employeeId).
                then().
                extract().
                response();

        return response;
    }

    public static Response deleteEmployeeRequest() {
        Response response = given().
                contentType("application/json").
                when().
                //body(deleteEmployee()).
                        log().all().
                delete(ReqresURL + "/api/users/" + employeeId).
                then().
                extract().
                response();

        return response;
    }
}
