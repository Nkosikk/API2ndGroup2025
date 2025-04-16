package RequestBuilder;

import io.restassured.response.Response;

import static PayloadBuilder.ReqResPayloadBuilder.createEmployeeResponse;
import static common.BasePaths.reqRes_baseUrl;
import static io.restassured.RestAssured.given;

public class ReqResRequestBuilder {

    public static String employeeNumber;
    public static Response createEmployeeRequest(){

        Response response = given().contentType("application/json")
                .when()
                .body(createEmployeeResponse())
                .log().all()
                .post(reqRes_baseUrl+"/api/users")
                .then()
                .extract().response();

        employeeNumber = response.jsonPath().getString("id");

        return response;
    }


}
